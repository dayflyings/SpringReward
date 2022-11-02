package com.example.retailrewards.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column(name = "amount")
    BigDecimal value;

    @Column(name = "user_id")
    Long userId;

    @Column(name = "created_time")
    Date createdTime;

    public TransactionEntity(Long id, BigDecimal value, Long userId, Date createdTime) {
        this.id = id;
        this.value = value;
        this.userId = userId;
        this.createdTime = createdTime;
    }

    public TransactionEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
