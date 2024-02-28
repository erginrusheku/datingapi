package com.bharath.dating.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private int age;
    private String email;
    private String gender;
    private String phoneNumber;
    private String city;
    private String country;
    @OneToOne(mappedBy = "userAccount")
    private Interest interest;

}
