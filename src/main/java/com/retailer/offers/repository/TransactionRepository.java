package com.retailer.offers.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.retailer.offers.entity.Transactions;

public interface TransactionRepository extends CrudRepository<Transactions,Long> {
   
    @Query("select SUM(a.amount) from Transactions a where a.customerId = ?1 and a.createDt > ?2 and a.createDt < ?3")
    public Long findTransactionsByCustomersAndDate(Long customerId, Timestamp from, Timestamp now);
    
    @Query("select a from Transactions a")
    public List<Transactions> getAll();

}