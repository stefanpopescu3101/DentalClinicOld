package com.example.dentalclinic.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name ="lottery")
public class Lottery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 36)
    private @Getter @Setter Integer id;
    @Column(name = "name")
    private @Getter @Setter String name;
    @Column(name = "capacity")
    private @Getter @Setter Integer capacity;

    @Column(name = "description")
    private @Getter @Setter String description;
    @OneToMany(cascade= {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST})
    private @Getter @Setter Collection<Client> attendees = new ArrayList<>();

    public Lottery(Integer id, String name, Integer capacity, Collection<Client> attendees) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.attendees = attendees;
    }

    public Lottery() {

    }
}
