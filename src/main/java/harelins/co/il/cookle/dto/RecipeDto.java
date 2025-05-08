package harelins.co.il.cookle.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDto {
    private Long id;
    private String name;
    private Integer yield;
    private List<IngredientDto> ingredients;
    private List<InstructionDto> instructions;
}
