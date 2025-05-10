package harelins.co.il.cookle.service.impl;

import harelins.co.il.cookle.dto.RecipeDto;
import harelins.co.il.cookle.service.AggregationService;
import harelins.co.il.cookle.service.ServerListService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * Implementation of AggregationService
 */
@Service
@RequiredArgsConstructor
public class AggregationServiceImpl implements AggregationService {

    private final RestTemplate restTemplate;
    private final ServerListService serverListService;
    private final ExecutorService executorService = newCachedThreadPool();

    @Override
    public List<RecipeDto> searchRecipes(String query) {
        List<CompletableFuture<List<RecipeDto>>> futures = serverListService.getAllServers().stream()
                .map(server -> CompletableFuture.supplyAsync(() -> {
                    String url = server + "/api/recipes/search?query=" + query;
                    try {
                        ResponseEntity<List<RecipeDto>> response = restTemplate.exchange(
                                url,
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<>() {
                                });
                        assert response.getBody() != null;
                        return response.getBody().stream().peek(r->r.setServerUrl(server)).toList();
                    } catch (Exception e) {
                        return List.<RecipeDto>of();
                    }
                }, executorService))
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> getRecipeDetails(Long id) {
        List<CompletableFuture<RecipeDto>> futures = serverListService.getAllServers().stream()
                .map(server -> CompletableFuture.supplyAsync(() -> {
                    String url = server + "/api/recipes/" + id;
                    try {
                        return restTemplate.getForObject(url, RecipeDto.class);
                    } catch (Exception e) {
                        return null;
                    }
                }, executorService))
                .toList();

        return futures.stream()
                .map(CompletableFuture::join)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}