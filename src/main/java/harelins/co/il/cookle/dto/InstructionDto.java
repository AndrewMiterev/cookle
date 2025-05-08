package harelins.co.il.cookle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InstructionDto {
    private Long id;
    private String description;
    private Integer step;
}
