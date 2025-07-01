package com.example.charter.repository;

import com.example.charter.pojo.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RetailRepository {
    private static final ArrayList<Transaction> transactions = new ArrayList<>();
    static {
        transactions.add(new Transaction(1L, 101L, 50));
        transactions.add(new Transaction(2L, 101L, 120));
        transactions.add(new Transaction(3L, 102L, 75));
        transactions.add(new Transaction(4L, 103L, 200));
        transactions.add(new Transaction(5L, 101L, 60));
        transactions.add(new Transaction(6L, 102L, 45));
    }
    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
