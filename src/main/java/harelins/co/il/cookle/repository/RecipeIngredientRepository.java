package harelins.co.il.cookle.repository;

import harelins.co.il.cookle.model.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link RecipeIngredient} entities.
 * Provides CRUD operations and query methods for recipe-ingredient relationships.
 */
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}