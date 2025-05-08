package harelins.co.il.cookle.service;

import harelins.co.il.cookle.dto.IngredientDto;
import harelins.co.il.cookle.dto.InstructionDto;
import harelins.co.il.cookle.dto.RecipeDto;
import harelins.co.il.cookle.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapper {
    public RecipeDto toDto(Recipe recipe) {
        RecipeDto dto = new RecipeDto();
        dto.setId(recipe.getId());
        dto.setName(recipe.getName());
        dto.setYield(recipe.getYield());

        dto.setIngredients(recipe.getIngredients().stream()
                .map(ri -> {
                    IngredientDto ingDto = new IngredientDto();
                    ingDto.setId(ri.getIngredient().getId());
                    ingDto.setName(ri.getIngredient().getName());
                    ingDto.setAmount(ri.getIngredient().getAmount());
                    return ingDto;
                })
                .toList());

        dto.setInstructions(recipe.getInstructions().stream()
                .map(i -> new InstructionDto(i.getId(), i.getDescription(), i.getStep()))
                .toList());

        return dto;
    }
}
