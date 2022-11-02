package com.example.retailrewards.controller;

import com.example.retailrewards.service.RewardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardController {

    RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping("/rewards/{id}")
    public ResponseEntity<Integer> calculateRewardById(@PathVariable Long id) {
        Integer points = rewardService.calculatePointByUserId(id);
        return new ResponseEntity<>(points, HttpStatus.OK);
    }
}
