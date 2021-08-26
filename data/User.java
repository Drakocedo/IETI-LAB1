package edu.eci.Microservices.data;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class User {

    private static AtomicInteger idGen = new AtomicInteger(0);


    private int id;
    private String name;
    private String email;
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    private LocalDate createdAt;

    public User(int id, String name, String email, String lastName, LocalDate createdAt) {
        this.id = idGen.incrementAndGet();
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.createdAt = createdAt;
    }


}
