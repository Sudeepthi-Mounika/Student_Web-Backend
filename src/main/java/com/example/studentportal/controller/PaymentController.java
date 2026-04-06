package com.example.studentportal.controller;

import com.example.studentportal.entity.Payment;
import com.example.studentportal.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/student/{email}")
    public List<Payment> getPaymentsByStudent(@PathVariable String email) {
        return paymentRepository.findByStudentEmail(email.toLowerCase());
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment) {
        payment.setStudentEmail(payment.getStudentEmail().toLowerCase());
        return paymentRepository.save(payment);
    }
}