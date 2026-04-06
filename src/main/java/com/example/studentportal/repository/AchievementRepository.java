package com.example.studentportal.repository;

import com.example.studentportal.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByStudentEmail(String studentEmail);
}