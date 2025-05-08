package harelins.co.il.cookle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RECIPES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"ingredients", "instructions"})
@EqualsAndHashCode(exclude = {"ingredients", "instructions"})
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer yield;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<RecipeIngredient> ingredients = new HashSet<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<Instruction> instructions = new HashSet<>();
}
