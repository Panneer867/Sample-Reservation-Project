package com.railway.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

	@Pattern(regexp = "^[A-Za-z, ]++$", message = "Numbers are not allowed as First Name")
    @Size(min = 2, message = "First Name must have at least 2 characters")
    private String firstName;

	@Pattern(regexp = "^[A-Za-z, ]++$", message = "Numbers are not allowed as Last Name")
    @Size(min = 2, message = "Last Name must have at least 2 characters")
    private String lastName;

    @Column(unique = true)
    @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Your Email is Invalid, Please enter again")
    private String email;

    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must have at least 8 characters and alphanumeric")
    private String password;
    
    @Pattern(regexp = "[0-9]+", message = "Please Enter a Valid Mobile Number")
    @Size(min = 10,max = 12, message = "Mobile must have 10 Digits")
    private String mobile;

    @Pattern(regexp = "^[0-9]{4}[ -]?[0-9]{4}[ -]?[0-9]{4}$",message = "Please Enter Again, Aadhar Number is invalid")
    private String aadhar;

    private String address;


    public UserRegistrationDto() {

    }


    public UserRegistrationDto(String firstName, String lastName, String email, String password,
        String mobile, String aadhar, String address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.aadhar = aadhar;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}