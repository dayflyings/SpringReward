package com.example.retailrewards.dao;

import com.example.retailrewards.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findTransactionEntitiesByUserId(Long userId);
}
