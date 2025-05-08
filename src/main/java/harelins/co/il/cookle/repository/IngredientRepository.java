package harelins.co.il.cookle.repository;

import harelins.co.il.cookle.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
