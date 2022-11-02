package com.example.retailrewards.service;

import com.example.retailrewards.dao.TransactionDAO;
import com.example.retailrewards.model.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDAO transRepo;

    @Override
    public TransactionEntity saveTransaction(TransactionEntity transactionEntity) {
        return transRepo.save(transactionEntity);
    }

    @Override
    public List<TransactionEntity> findTransactionByUserId(Long userId) {
        return transRepo.findTransactionEntitiesByUserId(userId);
    }
}
