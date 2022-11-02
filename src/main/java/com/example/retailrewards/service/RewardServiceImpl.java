package com.example.retailrewards.service;

import com.example.retailrewards.dao.TransactionDAO;
import com.example.retailrewards.model.TransactionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    TransactionDAO transDAO;

    private static final Logger log = LoggerFactory.getLogger(RewardServiceImpl.class);
    @Override
    public Integer calculatePointByUserId(Long userId) {
        List<TransactionEntity> allTrans = transDAO.findTransactionEntitiesByUserId(userId);
        Integer res = 0;
        BigDecimal totalSpent = BigDecimal.valueOf(0.0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date today = new Date();
        Integer limit = 90;
        Date startDate = new Date(today.getTime() - limit * 24 * 60 * 60 * 1000L);
        for (TransactionEntity tran : allTrans) {
            if (tran.getCreatedTime().after(startDate)) {
                totalSpent = totalSpent.add(tran.getValue());
            }
        }
        Integer totalInt = totalSpent.intValue();
        log.info("Current start= " + startDate);
        log.info("Current value= " + totalInt);
        if (totalInt > 50 && totalInt <= 100) {
            res = totalInt - 50;
        } else if (totalInt > 100) {
            res = (totalInt - 100) * 2 + 50;
        }
        return res;
    }
}
