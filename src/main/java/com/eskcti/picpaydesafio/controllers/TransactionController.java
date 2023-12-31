package com.eskcti.picpaydesafio.controllers;

import com.eskcti.picpaydesafio.domain.transaction.Transaction;
import com.eskcti.picpaydesafio.dtos.TransactionDTO;
import com.eskcti.picpaydesafio.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTransaction);
    }
}
