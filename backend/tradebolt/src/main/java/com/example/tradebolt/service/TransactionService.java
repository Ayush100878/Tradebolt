package com.example.tradebolt.service;

import com.example.tradebolt.Modal.Wallet;
import com.example.tradebolt.Modal.WalletTransaction;
import com.example.tradebolt.domain.WalletTransactionType;

import java.util.List;

public interface TransactionService {
    WalletTransaction createTransaction(Wallet wallet, WalletTransactionType type, Long receiverId, String purpose, Long amount);
    List<WalletTransaction> getTransactionsByWalletId(Long walletId);
}
