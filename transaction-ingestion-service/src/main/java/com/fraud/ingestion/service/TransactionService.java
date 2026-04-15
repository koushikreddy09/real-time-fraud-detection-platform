package com.fraud.ingestion.service;

import com.fraud.ingestion.entity.TransactionEntity;
import com.fraud.ingestion.model.TransactionRequest;
import com.fraud.ingestion.repository.TransactionRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final KafkaTemplate<String, TransactionRequest> kafkaTemplate;

    public TransactionService(TransactionRepository transactionRepository,
                              KafkaTemplate<String, TransactionRequest> kafkaTemplate) {
        this.transactionRepository = transactionRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void ingestTransaction(TransactionRequest request) {
        TransactionEntity entity = new TransactionEntity();
        entity.setTransactionId(request.getTransactionId());
        entity.setCustomerId(request.getCustomerId());
        entity.setMerchantId(request.getMerchantId());
        entity.setDeviceId(request.getDeviceId());
        entity.setAmount(request.getAmount());
        entity.setCurrency(request.getCurrency());
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setIpAddress(request.getIpAddress());
        entity.setStatus("RECEIVED");
        entity.setRiskScore(0);
        entity.setDecision("PENDING");
        entity.setCreatedAt(request.getTimestamp());

        transactionRepository.save(entity);
        kafkaTemplate.send("transactions.raw", request.getCustomerId(), request);
    }
}
