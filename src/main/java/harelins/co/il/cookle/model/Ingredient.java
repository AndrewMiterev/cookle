package harelins.co.il.cookle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Entity representing an ingredient in a recipe.
 */
@Entity
@Table(name = "INGREDIENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "recipes")
@EqualsAndHashCode(exclude = "recipes")
public class Ingredient {

    /**
     * The unique identifier of the ingredient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the ingredient.
     */
    private String name;

    /**
     * The amount of the ingredient (e.g., in grams or units).
     */
    private Double amount;

    /** The set of recipe-ingredient relationships for this ingredient. */
    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipes = new HashSet<>();
}