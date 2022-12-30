package com.example.dentalclinic.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="service")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 36)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private Integer duration;

    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToOne(targetEntity = Doctor.class, cascade = CascadeType.ALL)
    private @Getter @Setter Doctor doctor;

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
        return  "Treatment {" +
                " title='" + title + '\'' +
                " duration='" + duration + '\'' +
                " price='" + price + '\'' +
                ",description='" + description + '\'' +
                '}';
    }
}
