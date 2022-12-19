package com.example.dentalclinic.Models;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@AllArgsConstructor
@Table(name ="customer")
public class Client {
    @Id
    @Column(length = 36)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "cnp")
    private Integer cnp;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email")
    private String email;

    @Column(name = "verified")
    private Boolean verified;

    public Client(){

    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer ID) {
        this.id = ID;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getCNP() {
        return cnp;
    }

    public void setCNP(Integer cnp) {
        this.cnp = cnp;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Client(Integer id, String firstName, String lastName, String sex, String birthday, Integer cnp, Integer phone, String email, boolean verified)
    {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.sex=sex;
        this.birthday=birthday;
        this.cnp=cnp;
        this.phone=phone;
        this.email=email;
        this.verified=verified;
    }

    @Override
    public String toString() {
        return  "Customer {" +
                ",fullName='" + firstName + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cnp='" + cnp + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
