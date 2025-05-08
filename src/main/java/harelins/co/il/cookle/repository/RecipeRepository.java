package harelins.co.il.cookle.repository;

import harelins.co.il.cookle.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing {@link Recipe} entities.
 * Provides CRUD operations and custom query methods for recipes.
 */
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    /**
     * Finds recipes whose names contain the specified string, ignoring case.
     *
     * @param namePart the partial name to search for
     * @return a list of {@link Recipe} entities matching the search criteria
     */
    List<Recipe> findByNameContainingIgnoreCase(String namePart);
}