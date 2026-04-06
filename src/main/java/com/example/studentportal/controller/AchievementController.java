package com.example.studentportal.controller;

import com.example.studentportal.entity.Achievement;
import com.example.studentportal.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = "http://localhost:3000")
public class AchievementController {

    @Autowired
    private AchievementRepository achievementRepository;

    @GetMapping
    public List<Achievement> getAll() {
        return achievementRepository.findAll();
    }

    @GetMapping("/student/{email}")
    public List<Achievement> getByStudent(@PathVariable String email) {
        return achievementRepository.findByStudentEmail(email.toLowerCase());
    }

    @PostMapping
    public Achievement addAchievement(@RequestBody Achievement achievement) {
        achievement.setStudentEmail(achievement.getStudentEmail().toLowerCase());
        return achievementRepository.save(achievement);
    }

    @PutMapping("/{id}")
    public Achievement updateAchievement(@PathVariable Long id, @RequestBody Achievement updated) {
        updated.setId(id);
        return achievementRepository.save(updated);
    }

    @DeleteMapping("/{id}")
    public String deleteAchievement(@PathVariable Long id) {
        achievementRepository.deleteById(id);
        return "Deleted successfully";
    }
}