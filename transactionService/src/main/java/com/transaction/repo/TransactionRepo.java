package com.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}

