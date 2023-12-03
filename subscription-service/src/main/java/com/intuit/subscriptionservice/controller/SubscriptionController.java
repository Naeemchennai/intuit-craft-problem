package com.intuit.subscriptionservice.controller;

import com.intuit.subscriptionservice.dto.NewSubscriptionReqDTO;
import com.intuit.subscriptionservice.dto.SubscriptionDTO;
import com.intuit.subscriptionservice.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public SubscriptionDTO createNewSubscription(@RequestBody NewSubscriptionReqDTO newSubscriptionReqDTO) {
        return subscriptionService.createNewSubscription(newSubscriptionReqDTO);
    }

    @PutMapping
    public SubscriptionDTO updateSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        return subscriptionService.updateSubscription(subscriptionDTO);
    }

    @GetMapping
    public SubscriptionDTO getSubscription(@RequestParam("clientId") String clientId) {
       return subscriptionService.getSubscription(clientId);
    }
}
