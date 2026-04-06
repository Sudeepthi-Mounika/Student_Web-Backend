package com.example.studentportal.repository;

import com.example.studentportal.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderEmailAndReceiverEmail(String senderEmail, String receiverEmail);
}