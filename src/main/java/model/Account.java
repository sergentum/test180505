package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "account")
public class Account {
    @Id
    @Column(name = "_id")
    private Integer id;

    @Column
    private String title;
}
