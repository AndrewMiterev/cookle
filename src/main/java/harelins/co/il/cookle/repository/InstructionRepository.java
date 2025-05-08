package harelins.co.il.cookle.repository;

import harelins.co.il.cookle.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructionRepository extends JpaRepository<Instruction, Long> {
}
