package com.adrianjaylopez.webstore.dao;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * @author Adrian J Lopez
 * @version 1.0
 * @since <pre>11/10/15</pre>
 */

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USERNAME")
    @NotEmpty
    private String username;

    @Column(name = "PASSWORD")
    @NotEmpty
    private String password;

    @Column(name = "USER_AUTHORIZATION")
    private int userAuth;

    public User() {
    }

    public User(String username, String password, int userAuth) {
        this.username = username;
        this.password = password;
        this.userAuth = userAuth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(int userAuth) {
        this.userAuth = userAuth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userAuth='" + userAuth + '\'' +
                '}';
    }
}
