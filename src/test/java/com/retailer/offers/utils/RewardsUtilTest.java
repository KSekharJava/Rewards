package com.retailer.offers.utils;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.retailer.offers.model.Rewards;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RewardsUtilTest {
	
	@Autowired
	private RewardsUtil rewardsUtil;
	
	@Test
	public void testCalculateRewardsForAmountLessThan50() {
		int actual =rewardsUtil.calculateRewards(10L);
		assertEquals(0,actual);
	}
	@Test
	public void testCalculateRewardsForAmountBetween50And100() {
		int actual =rewardsUtil.calculateRewards(80L);
		assertEquals(30,actual);
	}
	
	@Test
	public void testCalculateRewardsForAmountAbove100() {
		int actual =rewardsUtil.calculateRewards(120L);
		assertEquals(90,actual);	
	}
	
	@Test
	public void testProcessResponse() {
		Long customerId=1L;
		Long lastMonthAmountSpent=10L;
		Long lastSecondMonthAmountSpent=80L;
		Long lastThirdMonthAmountSpent=120L;
		Rewards rewards =rewardsUtil.processResponse(customerId,lastMonthAmountSpent,lastSecondMonthAmountSpent,lastThirdMonthAmountSpent);
		assertEquals(customerId,rewards.getCustomerId());
		assertEquals(lastMonthAmountSpent,rewards.getLastMonthAmountSpent());
		assertEquals(lastSecondMonthAmountSpent,rewards.getLastSecondMonthAmountSpent());
		assertEquals(lastThirdMonthAmountSpent,rewards.getLastThirdMonthAmountSpent());
		assertEquals(0,rewards.getLastMonthRewardPoints());
		assertEquals(30,rewards.getLastSecondMonthRewardPoints());
		assertEquals(90,rewards.getLastThirdMonthRewardPoints());
	}
	
    
}
