package harelins.co.il.cookle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INGREDIENTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "recipes")
@EqualsAndHashCode(exclude ="recipes")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double amount;

    @OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredient> recipes = new HashSet<>();
}