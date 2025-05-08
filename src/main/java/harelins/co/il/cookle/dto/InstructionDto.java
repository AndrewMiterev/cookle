package harelins.co.il.cookle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing a recipe instruction.
 */
@Data
@AllArgsConstructor
public class InstructionDto {

    /** The unique identifier of the instruction. */
    private Long id;

    /** The description of the instruction. */
    private String description;

    /** The step number of the instruction in the recipe. */
    private Integer step;
}