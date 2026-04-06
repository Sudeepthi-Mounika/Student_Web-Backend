package com.example.studentportal.repository;

import com.example.studentportal.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentEmail(String studentEmail);
}