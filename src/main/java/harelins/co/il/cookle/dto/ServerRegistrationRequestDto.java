package harelins.co.il.cookle.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto fro server registration
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerRegistrationRequestDto {
    @NotBlank
    private String serverUrl;
    private String authToken; // 4 security
}