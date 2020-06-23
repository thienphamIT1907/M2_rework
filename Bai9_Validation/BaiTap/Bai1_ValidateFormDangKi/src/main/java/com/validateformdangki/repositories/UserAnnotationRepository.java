package com.validateformdangki.repositories;

import com.validateformdangki.models.UserAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface UserAnnotationRepository extends JpaRepository<UserAnnotation, Integer> {
    String findAllByBirthdayContaining(String date);
}
