package harelins.co.il.cookle.repository;

import harelins.co.il.cookle.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Instruction} entities.
 * Provides CRUD operations and query methods for instructions.
 */
public interface InstructionRepository extends JpaRepository<Instruction, Long> {
}