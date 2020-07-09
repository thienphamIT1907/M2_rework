package com.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee implements Validator{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String employeeGroup;

    @Column
    String name;

    @Column
    private String birthday;

    @Column
    private String gender;

    @Column
    private String phoneNumber;

    @Column
    private String cmnd;

    @Column
    private String email;

    @Column
    private String address;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "name", "data.empty");
        ValidationUtils.rejectIfEmpty(errors, "gender", "data.empty");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "data.empty");
        ValidationUtils.rejectIfEmpty(errors, "cmnd", "data.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "data.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "data.empty");

        Employee employee = (Employee) target;

        String phoneNumber = employee.phoneNumber;

        String email = employee.email;

        String cmnd = employee.cmnd;

        String gender = employee.gender;

        String birthday = employee.birthday;

        if(!phoneNumber.matches("^\\d{10,11}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.format");
        }

        if(!email.matches("^[a-zA-Z0-9]+@[a-z]+.com$")) {
            errors.rejectValue("email", "email.format");
        }

        if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            errors.rejectValue("gender", "gender.invalid");
        }

        if(!cmnd.matches("^\\d{9,12}$")) {
            errors.rejectValue("cmnd", "cmnd.length");
        }


        if (birthday.isEmpty()) {
            errors.rejectValue("birthday", "birthday.empty");
        } else if(!birthday.matches("^\\d{4}-\\d{2}-\\d{2}$")){ // => ("yyyy-MM-dd"), change pattern if you want
            errors.rejectValue("birthday", "birthday.format");
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //pattern to save DB
            try {
                simpleDateFormat.parse(birthday);
            } catch (ParseException e) {
                errors.rejectValue("birthday", "birthday.format");
            }
        }
    }
}


//LocalDate today = LocalDate.now();                          //Today's date
//    LocalDate birthday = LocalDate.of(1959,8, 04);  //Birth date
//
//    Period p = Period.between(birthday, today);
//        System.out.println(p.getYears());


//if (birthday.isEmpty()) {
//        errors.rejectValue("birthday", "birthday.empty");
//        } else if(!birthday.matches("^\\d{4}-\\d{2}-\\d{2}$")){ // => ("yyyy-MM-dd"), change pattern if you want
//        errors.rejectValue("birthday", "birthday.format");
//        } else {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); //pattern to save DB
//        try {
//        simpleDateFormat.parse(birthday);
//        } catch (ParseException e) {
//        errors.rejectValue("birthday", "birthday.format");
//        }
//        }