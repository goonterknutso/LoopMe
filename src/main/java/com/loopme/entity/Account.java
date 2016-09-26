package com.loopme.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent an Account using Hibernate
 *
 * @author Gunther Knutson
 */

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "user_id")
    private int userId;

    /**
     * Constructor (empty) for a new Account
     */
    public Account(){
    }

    /**
     * Constructor (with parameters) for a new Account
     * @param username  the username
     * @param password  the password
     * @param userId    the user id
     */
    public Account(String username, String password, int userId) {
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    /**
     * Gets the account id
     * @return the account id
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Sets the account id
     * @param accountId the account id
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user id
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user id
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }


}
