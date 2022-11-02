package com.example.retailrewards.controller;

import com.example.retailrewards.model.TransactionEntity;
import com.example.retailrewards.service.TransactionService;
import com.example.retailrewards.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    TransactionService transService;

    UserService userService;

    public TransactionController(TransactionService transService, UserService userService) {
        this.transService = transService;
        this.userService = userService;
    }

    @PostMapping("/transaction")
    private ResponseEntity<TransactionEntity> saveTransaction(@RequestBody TransactionEntity trans) {
        if (trans.getValue().intValue() < 0) {
            throw new RuntimeException("Illegal value input.");
        }
        if (userService.findUserById(trans.getUserId()) == null) {
            throw new RuntimeException("User not found.");
        }
        TransactionEntity savedTrans = transService.saveTransaction(trans);
        if (savedTrans == null) {
            throw new RuntimeException("Save transactions failed.");
        }
        return new ResponseEntity<>(savedTrans, HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{id}")
    private ResponseEntity<List<TransactionEntity>> findTransactionsByUserId(@PathVariable Long id) {
         List<TransactionEntity> transList = transService.findTransactionByUserId(id);
         if (transList.size() == 0) {
             return new ResponseEntity<>(transList, HttpStatus.NOT_FOUND);
         } else {
             return new ResponseEntity<>(transList, HttpStatus.OK);
         }
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
