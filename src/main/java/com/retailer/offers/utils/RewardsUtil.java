package com.retailer.offers.utils;

import org.springframework.stereotype.Component;
import com.retailer.offers.model.Rewards;

@Component
public class RewardsUtil {
		  
    public Rewards processResponse(Long customerId,
    		Long lastMonthAmountSpent,
    		Long lastSecondMonthAmountSpent,
    		Long lastThirdMonthAmountSpent
    		) {   	
		Rewards rewards = new Rewards();
		rewards.setCustomerId(customerId);
		rewards.setLastMonthAmountSpent(lastMonthAmountSpent);
		rewards.setLastSecondMonthAmountSpent(lastSecondMonthAmountSpent);
		rewards.setLastThirdMonthAmountSpent(lastThirdMonthAmountSpent);
		rewards.setLastMonthRewardPoints(calculateRewards(lastMonthAmountSpent));
		rewards.setLastSecondMonthRewardPoints(calculateRewards(lastSecondMonthAmountSpent));
		rewards.setLastThirdMonthRewardPoints(calculateRewards(lastThirdMonthAmountSpent));	
    	return rewards;
    }
    
	public int calculateRewards(Long amount) {	
		if (amount > 100) {
			return Math.round(amount - 100) * 2 + (100 - 50);
		}else if (amount > 50 && amount <= 100) {
			return Math.round(amount - 50);
		} else
			return 0;
	}

}
