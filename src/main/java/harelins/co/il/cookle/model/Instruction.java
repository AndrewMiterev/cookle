package harelins.co.il.cookle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RECIPES_INSTRUCTIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "recipe")
@EqualsAndHashCode(exclude = "recipe")
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Recipe recipe;

    private Integer step;

    private String description;
}