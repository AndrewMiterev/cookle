package harelins.co.il.cookle.repository;

import harelins.co.il.cookle.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Ingredient} entities.
 * Provides CRUD operations and query methods for ingredients.
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}