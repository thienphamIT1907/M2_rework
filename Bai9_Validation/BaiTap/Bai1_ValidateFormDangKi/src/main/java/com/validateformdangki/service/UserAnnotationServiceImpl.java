package com.validateformdangki.service;

import com.validateformdangki.models.UserAnnotation;
import com.validateformdangki.repositories.UserAnnotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserAnnotationServiceImpl implements UserAnnotationService {

    @Autowired
    UserAnnotationRepository userAnnotationRepository;

    @Override
    public void add(UserAnnotation userAnnotation) {
        userAnnotationRepository.save(userAnnotation);
    }

    @Override
    public void delete(Integer id) {
        userAnnotationRepository.deleteById(id);
    }

    @Override
    public UserAnnotation findById(Integer id) {
        return userAnnotationRepository.findById(id).orElse(null);
    }

    @Override
    public String findAllByBirthdayContaining(String date) {
        return userAnnotationRepository.findAllByBirthdayContaining(date);
    }
}
