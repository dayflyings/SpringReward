package com.example.retailrewards.service;

import com.example.retailrewards.model.TransactionEntity;

import java.util.List;

public interface TransactionService {
    public TransactionEntity saveTransaction(TransactionEntity transactionEntity);

    public List<TransactionEntity> findTransactionByUserId(Long userId);

}
