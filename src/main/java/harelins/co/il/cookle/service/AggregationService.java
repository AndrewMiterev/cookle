package harelins.co.il.cookle.service;

import harelins.co.il.cookle.dto.RecipeDto;

import java.util.List;

/**
 * Service for aggregating data from multiple servers
 */
public interface AggregationService {

    /**
     * Searches recipes across all configured servers
     *
     * @param query search term
     * @return combined list of recipes from all servers
     */
    List<RecipeDto> searchRecipes(String query);

    /**
     * Gets recipe details from all available servers
     *
     * @param id recipe ID
     * @return list of recipe details from all servers
     */
    List<RecipeDto> getRecipeDetails(Long id);
}