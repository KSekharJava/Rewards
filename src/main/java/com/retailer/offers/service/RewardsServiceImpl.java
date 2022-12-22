package com.retailer.offers.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.offers.entity.Transactions;
import com.retailer.offers.model.Rewards;

import lombok.extern.slf4j.Slf4j;

import com.retailer.offers.repository.CustomerRepository;
import com.retailer.offers.repository.TransactionRepository;
import com.retailer.offers.utils.RewardsUtil;

@Service
@Slf4j
public class RewardsServiceImpl implements RewardsService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RewardsUtil rewardsUtil;
	
	
	@Override
	public List<Transactions> getTransactions() {
		return transactionRepository.getAll();
	}

	@Override
	public Rewards getRewardsByCustomerId(Long customerId) {
		if(customerRepository.findByCustomerId(customerId) == null ) {
			 throw new RuntimeException("Customer Id is not valid");
		}
		Long lastMonthAmountSpent = getLoanAmount(customerId,30,0);	
		Long lastSecondMonthAmountSpent=getLoanAmount(customerId,60,30);
		Long lastThirdMonthAmountSpent=getLoanAmount(customerId,90,60);
		 return rewardsUtil.processResponse(customerId,lastMonthAmountSpent,lastSecondMonthAmountSpent,lastThirdMonthAmountSpent);
	}
	
	private Long getLoanAmount(Long customerId, int from, int to) {
		return transactionRepository.findTransactionsByCustomersAndDate(
				customerId, currentDateMinusDays(from), currentDateMinusDays(to));
	}
	
	private Timestamp currentDateMinusDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}
}
