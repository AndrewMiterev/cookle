package harelins.co.il.cookle.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing an ingredient.
 */
@Data
public class IngredientDto {

    /** The unique identifier of the ingredient. */
    private Long id;

    /** The name of the ingredient. */
    private String name;

    /** The amount of the ingredient (e.g., in grams or units). */
    private Double amount;
}