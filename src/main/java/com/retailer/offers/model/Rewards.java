package com.retailer.offers.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"customerId",
	"totalRewards",
	"lastMonthRewardPoints",
	"lastMonthAmountSpent",
	"lastSecondMonthRewardPoints",
	"lastSecondMonthAmountSpent",
	"lastThirdMonthRewardPoints",
	"lastThirdMonthAmountSpent"
})
public class Rewards {
	private Long customerId;
	private int totalRewards;
	private int lastMonthRewardPoints;
	private int lastSecondMonthRewardPoints;
	private int lastThirdMonthRewardPoints;
	private Long lastMonthAmountSpent;	
	private Long lastSecondMonthAmountSpent;
	private Long lastThirdMonthAmountSpent;
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public int getTotalRewards() {
		return lastMonthRewardPoints+lastSecondMonthRewardPoints+lastThirdMonthRewardPoints;
	}
	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}
	public int getLastMonthRewardPoints() {
		return lastMonthRewardPoints;
	}
	public void setLastMonthRewardPoints(int lastMonthRewardPoints) {
		this.lastMonthRewardPoints = lastMonthRewardPoints;
	}
	public int getLastSecondMonthRewardPoints() {
		return lastSecondMonthRewardPoints;
	}
	public void setLastSecondMonthRewardPoints(int lastSecondMonthRewardPoints) {
		this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
	}
	public int getLastThirdMonthRewardPoints() {
		return lastThirdMonthRewardPoints;
	}
	public void setLastThirdMonthRewardPoints(int lastThirdMonthRewardPoints) {
		this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
	}
	public Long getLastMonthAmountSpent() {
		return lastMonthAmountSpent;
	}
	public void setLastMonthAmountSpent(Long lastMonthAmountSpent) {
		this.lastMonthAmountSpent = lastMonthAmountSpent;
	}
	public Long getLastSecondMonthAmountSpent() {
		return lastSecondMonthAmountSpent;
	}
	public void setLastSecondMonthAmountSpent(Long lastSecondMonthAmountSpent) {
		this.lastSecondMonthAmountSpent = lastSecondMonthAmountSpent;
	}
	public Long getLastThirdMonthAmountSpent() {
		return lastThirdMonthAmountSpent;
	}
	public void setLastThirdMonthAmountSpent(Long lastThirdMonthAmountSpent) {
		this.lastThirdMonthAmountSpent = lastThirdMonthAmountSpent;
	}
	
}
