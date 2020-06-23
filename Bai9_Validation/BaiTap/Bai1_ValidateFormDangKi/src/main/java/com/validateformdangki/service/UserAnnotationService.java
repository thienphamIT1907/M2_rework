package com.validateformdangki.service;

import com.validateformdangki.models.UserAnnotation;

import java.time.LocalDate;

public interface UserAnnotationService {

    void add(UserAnnotation userAnnotation);

    void delete(Integer id);

    UserAnnotation findById(Integer id);

    String findAllByBirthdayContaining(String date);
}
