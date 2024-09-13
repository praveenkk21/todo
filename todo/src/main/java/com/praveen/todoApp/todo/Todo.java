package com.praveen.todoApp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Todo {
    public Todo() {

    }
    @Id
    @GeneratedValue
    private int id;

    @NotEmpty(message = "Username is required")
    private String username;
    @Size(min=10, message = "Please enter the min 10 characters")
    private String course;
    //@DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate date;
    private boolean done;

    public Todo(int id, String username, String course, LocalDate date, boolean done) {
        super();
        this.id = id;
        this.course = course;
        this.username = username;
        this.done = done;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getcourse() {
        return course;
    }

    public void setcourse(String course) {
        this.course = course;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", course='" + course + '\'' +
                ", date='" + date + '\'' +
                ", done=" + done +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Todo{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", course='" + course + '\'' +
//                ", done=" + done +
//                '}';
//    }
}
