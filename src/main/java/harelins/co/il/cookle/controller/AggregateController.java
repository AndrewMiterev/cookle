package harelins.co.il.cookle.controller;

import harelins.co.il.cookle.dto.RecipeDto;
import harelins.co.il.cookle.service.AggregationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for aggregated recipe operations.
 * Provides endpoints that combine results from multiple backend servers.
 */
@RestController
@RequestMapping("/api/aggregate")
@RequiredArgsConstructor
public class AggregateController {

    private final AggregationService aggregationService;

    /**
     * Searches recipes across all backend servers.
     *
     * @param query search term to match against recipe names
     * @return ResponseEntity containing combined list of RecipeDto from all servers
     */
    @GetMapping("/search")
    public ResponseEntity<List<RecipeDto>> aggregateSearch(@RequestParam String query) {
        return ResponseEntity.ok(aggregationService.searchRecipes(query));
    }

    /**
     * Retrieves recipe details from all backend servers.
     *
     * @param id unique identifier of the recipe
     * @return ResponseEntity containing list of RecipeDto from all servers (usually identical)
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<RecipeDto>> aggregateRecipeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(aggregationService.getRecipeDetails(id));
    }
}