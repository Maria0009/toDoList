package com.overone.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "description")
    private String description;

    @Column(name = "target_date")
    private Date targetDate;

    public Todo() {
    }

    public Todo(String user, String desc, Date targetDate, boolean isDone) {
        this.userName = user;
        this.description = desc;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}

