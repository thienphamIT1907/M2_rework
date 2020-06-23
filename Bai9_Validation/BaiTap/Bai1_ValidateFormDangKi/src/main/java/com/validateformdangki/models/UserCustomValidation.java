package com.validateformdangki.models;


import org.aspectj.lang.annotation.After;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserCustomValidation implements Validator {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private int age;

    private String email;

    private LocalDate birthday;

    public UserCustomValidation() {
    }

    public UserCustomValidation(String firstName, String lastName, String phoneNumber, int age, String email,
                                LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCustomValidation userCustomValidation = (UserCustomValidation) target;

        String firstName = userCustomValidation.getFirstName();
        String lastName = userCustomValidation.getLastName();
        String phoneNumber = userCustomValidation.getPhoneNumber();
        int age = userCustomValidation.getAge();
        String email = userCustomValidation.getEmail();
        LocalDate birthday = userCustomValidation.getBirthday();
//        String birthday = String.valueOf(userCustomValidation.getBirthday());

        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstname.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastname.empty");


        if(firstName.length() < 5 || firstName.length() > 45) {
            errors.rejectValue("firstName", "firstname.length");
        }

        if(lastName.length() < 5 || lastName.length() > 45) {
            errors.rejectValue("lastName", "lastname.length");
        }

        if(!phoneNumber.matches("^\\d{10}")) {
            errors.rejectValue("phoneNumber", "phonenumber.regex");
        }

        if(age < 18) {
            errors.rejectValue("age", "age.outrange");
        }

        if(!email.matches("^[a-zA-Z0-9]+@[a-z]+.com$")) {
            errors.rejectValue("email", "email.regex");
        }

        LocalDate dateValid = LocalDate.of(2020, 7, 19);

        if(birthday != null) {
//            LocalDate userDate = LocalDate.parse(birthday);
            if(!birthday.isAfter(dateValid)) {
                errors.rejectValue("birthday", "date.before");
            } else if (!String.valueOf(birthday).matches("^\\d+/\\d+/\\d+$")){
                errors.rejectValue("birthday", "date.format");
            }
        } else {
            ValidationUtils.rejectIfEmpty(errors, "birthday", "birthday.empty");
        }
    }
}
