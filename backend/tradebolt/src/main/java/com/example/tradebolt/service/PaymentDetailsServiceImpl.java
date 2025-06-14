//package com.ayush.tradebolt.service;
//
//import com.ayush.tradebolt.Modal.PaymentDetails;
//import com.ayush.tradebolt.Modal.User;
//import com.ayush.tradebolt.repository.PaymentDetailsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentDetailsServiceImpl implements PaymentDetailsService{
//
//    @Autowired
//    private PaymentDetailsRepository paymentDetailsRepository;
//
//    @Override
//    public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderName, String ifsc, String bankName, User user) {
//        PaymentDetails paymentDetails = new PaymentDetails();
//
//        paymentDetails.setAccountNumber(accountNumber);
//        paymentDetails.setAccountHolderName(accountHolderName);
//        paymentDetails.setIfsc(ifsc);
//        paymentDetails.setBankName(bankName);
//        paymentDetails.setUser(user);
//
//        return paymentDetailsRepository.save(paymentDetails);
//    }
//
//    @Override
//    public PaymentDetails getUsersPaymentDetails(User user) {
//        return paymentDetailsRepository.findByUserId(user.getId());
//    }
//}
package com.example.tradebolt.service;

import com.example.tradebolt.Modal.PaymentDetails;
import com.example.tradebolt.Modal.User;
import com.example.tradebolt.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderName, String ifsc, String bankName, User user) {
        PaymentDetails paymentDetails = paymentDetailsRepository.findByUserId(user.getId());

        if (paymentDetails == null) {
            // If no existing payment details, create a new one
            paymentDetails = new PaymentDetails();
            paymentDetails.setUser(user);
        }

        // Set or update the payment details
        paymentDetails.setAccountNumber(accountNumber);
        paymentDetails.setAccountHolderName(accountHolderName);
        paymentDetails.setIfsc(ifsc);
        paymentDetails.setBankName(bankName);

        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public PaymentDetails getUsersPaymentDetails(User user) {
        return paymentDetailsRepository.findByUserId(user.getId());
    }
}
