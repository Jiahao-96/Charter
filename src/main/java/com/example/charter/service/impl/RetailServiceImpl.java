package com.example.charter.service.impl;

import com.example.charter.pojo.Transaction;
import com.example.charter.repository.RetailRepository;
import com.example.charter.service.RetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RetailServiceImpl implements RetailService {
    @Autowired
    RetailRepository retailRepository;

    @Override
    public String calculatePoints() {
        List<Transaction> transactionList = retailRepository.getAllTransactions();

        Map<Long, Integer> customerPoints = new HashMap<>();

        for (Transaction transaction : transactionList) {
            int points = calculatePointsForTransaction(transaction.getPrice());
            customerPoints.compute(transaction.getCustomerId(), (key, val) -> (val == null) ? points : val + points);
        }

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Customer Reward Points:\n");

        customerPoints.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    resultBuilder.append("  Customer ID: ")
                            .append(entry.getKey())
                            .append(", Total Points: ")
                            .append(entry.getValue())
                            .append("\n");
                });

        return resultBuilder.toString();
    }
    private int calculatePointsForTransaction(int price) {
        int points = 0;

        if (price > 100) {
            points += (price - 100) * 2;
        }

        if (price > 50) {
            points += (Math.min(price, 100) - 50) * 1;
        }

        return points;
    }
}
