///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.boot.service.Impl;
//
//import com.boot.repository.PayPalRepository;
//import com.boot.service.PaypalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author AD
// */
//@Service
//public class PayPalServiceImpl implements PaypalService {
//
//    @Autowired
//    private PayPalRepository payPalRepository;
//    @Override
//    public Payment createPayment(Double total,String intent, String cancelUrl, String successUrl) {
//        return this.payPalRepository.createPayment(total,intent, cancelUrl, successUrl);
//    }
//
//    @Override
//    public Payment executePayment(String paymentId, String payerId) {
//        return this.payPalRepository.executePayment(payerId, payerId);
//    }
//
//}
