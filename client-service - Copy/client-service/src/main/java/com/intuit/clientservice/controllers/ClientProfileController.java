package com.intuit.clientservice.controllers;

import com.intuit.clientservice.dto.profile.ClientProfileReqDTO;
import com.intuit.clientservice.service.ClientProfileService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client-profile")
public class ClientProfileController {

    private final ClientProfileService clientProfileService;

    @PostMapping
    public ClientProfileReqDTO newClientProfile(@Valid @RequestBody ClientProfileReqDTO clientProfileReqDTO) {
        return clientProfileService.addClient(clientProfileReqDTO);
    }

    @GetMapping
    public ClientProfileReqDTO getClientProfile(@Valid @RequestParam("id") @NotNull(message = "clientId is empty") String clientId) {
        return clientProfileService.getClient(clientId);

    }

    @PutMapping
    public ClientProfileReqDTO updateClientProfile(@Valid @RequestBody ClientProfileReqDTO clientProfileReqDTO) {
        return clientProfileService.updateClient(clientProfileReqDTO);
    }

}
