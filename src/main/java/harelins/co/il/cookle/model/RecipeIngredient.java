package harelins.co.il.cookle.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing the relationship between a recipe and an ingredient.
 */
@Entity
@Table(name = "RECIPES_INGREDIENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"recipe", "ingredient"})
@EqualsAndHashCode(exclude = {"recipe", "ingredient"})
public class RecipeIngredient {

    /** The unique identifier of the recipe-ingredient relationship. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The recipe associated with this relationship. */
    @ManyToOne
    private Recipe recipe;

    /** The ingredient associated with this relationship. */
    @ManyToOne
    private Ingredient ingredient;
}