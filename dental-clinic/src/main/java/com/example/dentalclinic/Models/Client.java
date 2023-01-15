package com.example.dentalclinic.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@AllArgsConstructor
@Table(name ="customer")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 36)
    private @Getter @Setter Integer id;

    @Column(name = "username")
    private @Getter @Setter String username;

    @Column(name="password")
    private @Getter @Setter String password;

    @Column(name = "firstName")
    private @Getter @Setter String firstName;

    @Column(name = "lastName")
    private @Getter @Setter String lastName;

    @Column(name = "phone")
    private @Getter @Setter String phone;

    @Column(name = "email")
    private @Getter @Setter String email;

    @Column(name = "verified")
    private @Getter @Setter Boolean verified;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private @Getter @Setter Collection<Role> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity=Lottery.class, cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
    private @Getter @Setter Collection<Lottery> lotteries = new ArrayList<>();

    public Client(){

    }

    public Client(Integer id, String firstName, String lastName, String phone, String email, boolean verified)
    {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        this.email=email;
        this.verified=verified;
    }

}
