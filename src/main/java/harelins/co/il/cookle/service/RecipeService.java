package harelins.co.il.cookle.service;

import harelins.co.il.cookle.exception.ResourceNotFoundException;
import harelins.co.il.cookle.model.Recipe;
import harelins.co.il.cookle.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public List<Recipe> searchRecipes(String namePart) {
        return recipeRepository.findByNameContainingIgnoreCase(namePart);
    }

    public Recipe getRecipeDetails(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found"));
    }
}
