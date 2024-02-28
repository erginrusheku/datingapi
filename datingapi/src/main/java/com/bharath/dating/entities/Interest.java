package com.bharath.dating.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String likes;
    private String dislikes;
    private String hobbies;
    private String profileUrl;
    private String about;
    @Transient
    private int userAccountId;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserAccount userAccount;

}
