package com.example.dentalclinic.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="service")
public class Service {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "doctorID")
    private Integer doctorID;

    @Column(name = "doctorName")
    private String doctorName;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;

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

    public Integer getDoctorID()
    {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID)
    {
        this.doctorID=doctorID;
    }

    public String getDoctorName()
    {
        return doctorName;
    }

    public void setDoctorName(String doctorName)
    {
        this.doctorName=doctorName;
    }

    public Integer getDuration()
    {
        return duration;
    }

    public void setDuration(Integer duration)
    {
        this.duration=duration;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price=price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return  "Service {" +
                " title='" + title + '\'' +
                " doctorID='" + doctorID + '\'' +
                " doctorName='" + doctorName + '\'' +
                " duration='" + duration + '\'' +
                " price='" + price + '\'' +
                ",description='" + description + '\'' +
                '}';
    }
}
