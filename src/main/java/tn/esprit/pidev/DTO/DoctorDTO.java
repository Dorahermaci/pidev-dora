package tn.esprit.pidev.DTO;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class DoctorDTO {
    private Long id;

    private String firstName;
    private String lastName;
    private Integer nationalIdCard;
    private LocalDate dateOfBirth;
    private Integer phoneNumber;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getNationalIdCard() {
        return nationalIdCard;
    }

    public void setNationalIdCard(Integer nationalIdCard) {
        this.nationalIdCard = nationalIdCard;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
