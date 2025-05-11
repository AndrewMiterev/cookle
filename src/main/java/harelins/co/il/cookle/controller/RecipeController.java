package harelins.co.il.cookle.controller;

import harelins.co.il.cookle.dto.RecipeDto;
import harelins.co.il.cookle.exception.ResourceNotFoundException;
import harelins.co.il.cookle.model.Recipe;
import harelins.co.il.cookle.service.impl.RecipeMapper;
import harelins.co.il.cookle.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing recipe-related requests.
 * Handles search and retrieval of recipe details via REST endpoints.
 */
@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    /**
     * Searches for recipes based on a query string.
     *
     * @param query the search term to match against recipe names
     * @return a {@link ResponseEntity} containing a list of {@link RecipeDto} objects
     */
    @GetMapping("/search")
    public ResponseEntity<List<RecipeDto>> searchRecipes(@RequestParam String query) {
        List<Recipe> recipes = recipeService.searchRecipes(query);
        List<RecipeDto> results = recipes.stream().map(recipeMapper::toDto).toList();
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves detailed information for a specific recipe by its ID.
     *
     * @param id the ID of the recipe to retrieve
     * @return a {@link ResponseEntity} containing the {@link RecipeDto} for the recipe
     * @throws ResourceNotFoundException if the recipe is not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto> getRecipeDetails(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeDetails(id);
        return ResponseEntity.ok(recipeMapper.toDto(recipe));
    }
}