package com.example.dentalclinic.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="doctor")
public class Doctor {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "cnp")
    private Integer cnp;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email")
    private String email;

    @Column(name = "admin")
    private Boolean admin;


    public Doctor() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer ID) {
        this.id = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Doctor(Integer id, String title, String firstName, String lastName, String sex,
                  Date birthday, Integer cnp, Integer phone, String email, Boolean admin)
    {
        this.id = id;
        this.title = title;
        this.firstName=firstName;
        this.lastName=lastName;
        this.sex=sex;
        this.birthday=birthday;
        this.cnp=cnp;
        this.phone=phone;
        this.email=email;
        this.admin=admin;
    }

    @Override
    public String toString() {
        return  "Doctor {" +
                " title='" + title + '\'' +
                ",fullName='" + firstName + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cnp='" + cnp + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
