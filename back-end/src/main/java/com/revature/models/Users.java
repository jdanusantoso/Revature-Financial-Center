package com.revature.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity //This annotation makes this class a DB table (or database entity in other words)
@Table(name="users") //This annotation lets us give the DB table a different name
@Component //We want this class to be a bean
public class Users {

    @Id //This will make this field the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This makes our PK serial
    private int userId;

    //non-id columns don't technically need any annotation at all
    //BUT @Column is good for clarity and any constraints you may need

    @Column //now this column has a not null constraint
    private String firstName;

    @Column //now this column has a not null constraint
    private String lastName;


    @Column
    private String email;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(int userId, String firstName, String lastName, String email, String username, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
