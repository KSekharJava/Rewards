package com.retailer.offers.service;

import java.util.List;

import com.retailer.offers.entity.Transactions;
import com.retailer.offers.model.Rewards;

public interface RewardsService {
		
	Rewards getRewardsByCustomerId(Long customerId);
	
	List<Transactions> getTransactions();
	

}
