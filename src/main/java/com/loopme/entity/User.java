package com.loopme.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * A class to represent a user using Hibernate
 *
 * @author Gunther Knutson
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address_home")
    private int homeAddressId;

    /**
     * Constructor (empty) for a new User
     */
    public User(){
    }

    /**
     * Constructor (with parameters) for a new User
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param email       the email
     */
    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Constructor (with parameters including homeAddressId) for a new User
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param email       the email
     * @param homeAddressId the home address
     */
    public User(String firstName, String lastName, String email, int homeAddressId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.homeAddressId = homeAddressId;
    }

    /**
     * Gets user id
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

    /**
     * Gets first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets home address
     * @return the home address
     */
    public int getHomeAddressId() {
        return homeAddressId;
    }

    /**
     * Sets the home address
     * @param homeAddressId the home address
     */
    public void setHomeAddressId(int homeAddressId) {
        this.homeAddressId = homeAddressId;
    }
}
