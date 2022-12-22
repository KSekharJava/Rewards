package com.retailer.offers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.offers.entity.Transactions;
import com.retailer.offers.model.Rewards;
import com.retailer.offers.service.RewardsService;

@RestController
@RequestMapping("/v1")
public class RewardsController {
	
	@Autowired
    RewardsService rewardsService;
	
	
	@GetMapping(value = "rewards/{customerId}",produces = "application/json")
    public ResponseEntity<Rewards> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){  
        Rewards rewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(rewards,HttpStatus.OK);
    }
	
	
	@GetMapping(value = "transactions",produces = "application/json", consumes ="application/json")
    public ResponseEntity<List<Transactions>> getTransactions(@PathVariable("customerId") Long customerId){  
		List<Transactions> transactions = rewardsService.getTransactions();
        return new ResponseEntity<>(transactions,HttpStatus.OK);
    }

}
