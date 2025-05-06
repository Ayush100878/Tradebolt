package com.example.tradebolt.service;

import com.example.tradebolt.Modal.PaymentOrder;
import com.example.tradebolt.Modal.User;
import com.example.tradebolt.domain.PaymentMethod;
import com.example.tradebolt.response.PaymentResponse;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLing(User user, Long amount, Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLing(User user, Long amount,
                                            Long orderId) throws StripeException;

}
