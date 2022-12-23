package com.example.dentalclinic.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")

public class Role {
    @Id
    @Column(length = 36)
    private Integer id;
    private String name;


}
