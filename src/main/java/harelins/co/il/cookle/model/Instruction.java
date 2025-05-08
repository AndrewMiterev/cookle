package harelins.co.il.cookle.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing an instruction for a recipe.
 */
@Entity
@Table(name = "RECIPES_INSTRUCTIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "recipe")
@EqualsAndHashCode(exclude = "recipe")
public class Instruction {

    /** The unique identifier of the instruction. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The recipe associated with this instruction. */
    @ManyToOne
    private Recipe recipe;

    /** The step number of the instruction. */
    private Integer step;

    /** The description of the instruction. */
    private String description;
}