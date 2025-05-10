package harelins.co.il.cookle.service;

import harelins.co.il.cookle.exception.ResourceNotFoundException;
import harelins.co.il.cookle.model.Recipe;

import java.util.List;

/**
 * Service interface for recipe-related operations
 */
public interface RecipeService {

    /**
     * Searches recipes by name containing the given string (case insensitive)
     * @param namePart partial name to search for
     * @return list of matching recipes
     */
    List<Recipe> searchRecipes(String namePart);

    /**
     * Retrieves recipe details by ID
     * @param id recipe ID
     * @return recipe entity
     * @throws ResourceNotFoundException if recipe not found
     */
    Recipe getRecipeDetails(Long id) throws ResourceNotFoundException;
}