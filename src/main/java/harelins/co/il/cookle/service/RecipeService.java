package harelins.co.il.cookle.service;

import harelins.co.il.cookle.exception.ResourceNotFoundException;
import harelins.co.il.cookle.model.Recipe;
import harelins.co.il.cookle.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing recipe-related business logic.
 */
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    /**
     * Searches for recipes whose names contain the specified string, ignoring case.
     *
     * @param namePart the partial name to search for
     * @return a list of {@link Recipe} entities matching the search criteria
     */
    public List<Recipe> searchRecipes(String namePart) {
        return recipeRepository.findByNameContainingIgnoreCase(namePart);
    }

    /**
     * Retrieves a recipe by its ID.
     *
     * @param id the ID of the recipe to retrieve
     * @return the {@link Recipe} entity
     * @throws ResourceNotFoundException if the recipe is not found
     */
    public Recipe getRecipeDetails(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));
    }
}