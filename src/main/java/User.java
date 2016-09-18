/**
 * Created by gunther on 9/16/16.
 */
public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private Address homeAddress;

    public User(){

    }

    public User(int id, String firstName, String lastName, String email, Address address){

    }

    public User(String firstName, String lastName, String email){

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
