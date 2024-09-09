package com.praveen.todoApp.todo;

import jakarta.validation.constraints.Size;

public class todo {
    private int id;
    private String username;
    @Size(min=10, message = "Please enter the min 10 characters")
    private String course;
    private boolean done;

    public todo(int id, String username, String course,boolean done) {
        this.id = id;
        this.course = course;
        this.username = username;
        this.done = done;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", course='" + course + '\'' +
                ", done=" + done +
                '}';
    }
}
