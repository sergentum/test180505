package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    int id;

    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}