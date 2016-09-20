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

    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address_home")
    private Address homeAddress;

    /**
     * Constructor (empty) for a new User.
     */
    public User(){
    }

    /**
     * Constructor (with parameters including homeAddress) for a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param email       the email
     */
    public User(String firstName, String lastName, String email){

    }

    /**
     * Constructor (with parameters including homeAddress) for a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param email       the email
     * @param homeAddress the home address
     */
    public User(String firstName, String lastName, String email, Address homeAddress){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.homeAddress = homeAddress;
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
