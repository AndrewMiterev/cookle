package harelins.co.il.cookle.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RECIPES_INGREDIENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"recipe", "ingredient"})
@EqualsAndHashCode(exclude = {"recipe", "ingredient"})
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private Ingredient ingredient;
}