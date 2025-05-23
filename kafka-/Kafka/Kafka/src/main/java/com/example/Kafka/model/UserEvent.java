package com.example.Kafka.model;

public class UserEvent {
    private int id;
    private String name;
    private String email;

    // Constructors
    public UserEvent() {}
    public UserEvent(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters + Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "UserEvent{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}
