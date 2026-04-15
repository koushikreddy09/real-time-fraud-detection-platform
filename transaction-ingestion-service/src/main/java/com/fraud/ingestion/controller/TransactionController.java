package com.fraud.ingestion.controller;

import com.fraud.ingestion.model.TransactionRequest;
import com.fraud.ingestion.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> createTransaction(@Valid @RequestBody TransactionRequest request) {
        transactionService.ingestTransaction(request);
        return Map.of(
                "message", "Transaction received",
                "transactionId", request.getTransactionId()
        );
    }
}
