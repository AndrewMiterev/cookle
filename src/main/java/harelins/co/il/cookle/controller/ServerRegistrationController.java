package harelins.co.il.cookle.controller;

import harelins.co.il.cookle.dto.ServerRegistrationRequestDto;
import harelins.co.il.cookle.service.ServerListService;
import harelins.co.il.cookle.service.ServerRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servers")
@RequiredArgsConstructor
public class ServerRegistrationController {

    private final ServerListService serverListService;
    private final ServerRegistrationService registrationService;

    /**
     * Register new server in the cluster
     */
    @PostMapping("/register")
    public ResponseEntity<Void> registerServer(@RequestBody ServerRegistrationRequestDto request) {
        registrationService.registerNewServer(request);
        return ResponseEntity.ok().build();
    }

    /**
     * Get list of all known servers
     */
    @GetMapping
    public ResponseEntity<List<String>> getAllServers() {
        return ResponseEntity.ok(serverListService.getAllServers());
    }

    /**
     * Heartbeat endpoint for server health checks
     */
    @GetMapping("/heartbeat")
    public ResponseEntity<Void> heartbeat() {
        return ResponseEntity.ok().build();
    }
}