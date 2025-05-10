package harelins.co.il.cookle.dto;

import lombok.Data;

import java.util.List;

/**
 * Data Transfer Object (DTO) for representing a recipe.
 */
@Data
public class RecipeDto {

    /** The unique identifier of the recipe. */
    private Long id;

    /** The name of the recipe. */
    private String name;

    /** The number of servings the recipe yields. */
    private Integer yield;

    /** The list of ingredients required for the recipe. */
    private List<IngredientDto> ingredients;

    /** The list of instructions for preparing the recipe. */
    private List<InstructionDto> instructions;

    /** from witch server */
    private String serverUrl;
}