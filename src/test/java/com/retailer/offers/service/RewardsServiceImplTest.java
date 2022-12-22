package com.retailer.offers.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.retailer.offers.entity.Customer;
import com.retailer.offers.model.Rewards;
import com.retailer.offers.repository.CustomerRepository;
import com.retailer.offers.repository.TransactionRepository;
import com.retailer.offers.utils.RewardsUtil;

@RunWith(MockitoJUnitRunner.class)
public class RewardsServiceImplTest {
	
	@InjectMocks
	private RewardsServiceImpl rewardsServiceImpl;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private RewardsUtil rewardsUtil;
		
	@Test
	public void testGetRewardsByCustomerIdSuccess() {
		Long customerId=1L;
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		Long lastMonthAmountSpent=10L;
		Long lastSecondMonthAmountSpent=80L;
		Long lastThirdMonthAmountSpent=120L;
		when(customerRepository.findByCustomerId(customerId)).thenReturn(customer);
		when(transactionRepository
				.findTransactionsByCustomersAndDate(customerId,currentDateMinusDays(30),currentDateMinusDays(0)))
		           .thenReturn(lastMonthAmountSpent);
		when(transactionRepository
				.findTransactionsByCustomersAndDate(customerId,currentDateMinusDays(60),currentDateMinusDays(30)))
		           .thenReturn(lastSecondMonthAmountSpent);
		when(transactionRepository
				.findTransactionsByCustomersAndDate(customerId,currentDateMinusDays(90),currentDateMinusDays(60)))
		           .thenReturn(lastThirdMonthAmountSpent);
		Rewards rewards =rewardsServiceImpl.getRewardsByCustomerId(1L);
		
		assertEquals(customerId,rewards.getCustomerId());
		assertEquals(lastMonthAmountSpent,rewards.getLastMonthAmountSpent());
		assertEquals(lastSecondMonthAmountSpent,rewards.getLastSecondMonthAmountSpent());
		assertEquals(lastThirdMonthAmountSpent,rewards.getLastThirdMonthAmountSpent());
		assertEquals(0,rewards.getLastMonthRewardPoints());
		assertEquals(30,rewards.getLastSecondMonthRewardPoints());
		assertEquals(90,rewards.getLastThirdMonthRewardPoints());
	}
	
	
	@Test
	public void shouldThrowRuntimeExceptionWhenCustomerIDisNull() {
		RuntimeException thrown = assertThrows(
				RuntimeException.class,
		           () -> {	        	
		       		when(customerRepository.findByCustomerId(1L)).thenReturn(null);		
		       		rewardsServiceImpl.getRewardsByCustomerId(1L); 
		           }
		    );
		    assertTrue(thrown.getMessage().contentEquals("Customer Id is not valid"));
	}
	
	private Timestamp currentDateMinusDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}
}
