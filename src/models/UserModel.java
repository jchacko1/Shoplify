package models;

/**
 * Created by jmarquez on 10/20/2014.A
 */
public class UserModel implements User {

    private int userId;
    private String createDate;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private String DOB;
    private String gender;
    private boolean isAdmin;


    public UserModel(String username, String password, int userId, boolean isAdmin,
                     String firstName, String lastName, String address, String phoneNumber, String DOB, String gender) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.DOB = DOB;
        this.gender = gender;
    }

    //@precondition: this method has been called
    //@postcondition: user’s first name is set
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@precondition: this method has been called
    //@postcondition: the user’s last name is set
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@precondition: this method has been called
    //@postcondition: the user’s address is set
    public void setAddress(String address) {
        this.address = address;
    }


    //@precondition: this method has been called
    //@postcondition: the user’s phone number is set
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }


    //@precondition: this method has been called
    //@postcondition: the user’s date of birth is set
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }


    //@precondition: this method has been called
    //@postcondition: the user’s date of birth is set
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() { return gender;  }

    public boolean getUserType() {
        return isAdmin;
    }
}
