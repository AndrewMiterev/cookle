package harelins.co.il.cookle.controller;

import harelins.co.il.cookle.dto.RecipeDto;
import harelins.co.il.cookle.model.Recipe;
import harelins.co.il.cookle.service.RecipeMapper;
import harelins.co.il.cookle.service.RecipeService;
import jakarta.persistence.Cacheable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    @GetMapping("/search")
    public ResponseEntity<List<RecipeDto>> searchRecipes(@RequestParam String query) {
        List<Recipe> recipes = recipeService.searchRecipes(query);
        List<RecipeDto> results = recipes.stream().map(recipeMapper::toDto).toList();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeDetails(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeDetails(id);
        return ResponseEntity.ok(recipeMapper.toDto(recipe));
    }
}
