package com.example.tradebolt.service;

import com.example.tradebolt.Modal.PaymentDetails;
import com.example.tradebolt.Modal.User;

public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(String accountNumber,
                                            String accountHolderName,
                                            String ifsc,
                                            String bankName,
                                            User user);

    public PaymentDetails getUsersPaymentDetails(User user);
}
