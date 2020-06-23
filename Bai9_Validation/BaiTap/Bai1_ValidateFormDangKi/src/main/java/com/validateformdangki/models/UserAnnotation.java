package com.validateformdangki.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "user_annotation")
public class UserAnnotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_annotation")
    private Integer idUserAnnotation;

    @NotEmpty(message = "Not empty")
    @Size(min = 5, max = 45, message = "Length must be betwween 5 to 45")
    private String firstName;

    @NotEmpty(message = "Not empty")
    @Size(min = 5, max = 45, message = "Length must be betwween 5 to 45")
    private String lastName;

    @Pattern(regexp = "^\\d{10}", message = "Phone number must has 10 numbers and no space")
    private String phoneNumber;

    @Min(value = 18, message = "Your age must >=18")
    private int age;

    @Pattern(
        regexp = "^[a-zA-Z0-9]+@[a-z]+.com$",
        message = "Email format invalid"
    )
    private String email;

//    Co the dung LocalDate hay Date deu duoc

//    @NotNull(message = "Date must not null !")
//    @DateTimeFormat(pattern = "dd/MM/yyyy", iso = DateTimeFormat.ISO.DATE)
//    @Past(message = "Your date must not over this time !")
//    private LocalDate birthday;

    @NotNull(message = "Your date invalid! ")
    private Date birthday;

    public UserAnnotation() {
    }

    public UserAnnotation(Integer idUserAnnotation, @NotEmpty(message = "Not empty") @Size(min = 5, max = 45, message = "Length must be betwween 5 to 45") String firstName, @NotEmpty(message = "Not empty") @Size(min = 5, max = 45, message = "Length must be betwween 5 to 45") String lastName, @Pattern(regexp = "^\\d{10}", message = "Phone number must has 10 numbers") String phoneNumber, @Min(value = 18, message = "Your age must >=18") int age, @Pattern(
            regexp = "^[a-zA-Z0-9]+@[a-z]+.com$",
            message = "Email format invalid"
    ) String email, Date birthday) {
        this.idUserAnnotation = idUserAnnotation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.birthday = birthday;
    }

    public Integer getIdUserAnnotation() {
        return idUserAnnotation;
    }

    public void setIdUserAnnotation(Integer idUserAnnotation) {
        this.idUserAnnotation = idUserAnnotation;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
