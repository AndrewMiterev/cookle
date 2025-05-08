package harelins.co.il.cookle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing a recipe.
 */
@Entity
@Table(name = "RECIPES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"ingredients", "instructions"})
@EqualsAndHashCode(exclude = {"ingredients", "instructions"})
public class Recipe {

    /** The unique identifier of the recipe. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name of the recipe. */
    private String name;

    /** The number of servings the recipe yields. */
    private Integer yield;

    /** The set of ingredients required for the recipe. */
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<RecipeIngredient> ingredients = new HashSet<>();

    /** The set of instructions for preparing the recipe. */
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Instruction> instructions = new HashSet<>();
}