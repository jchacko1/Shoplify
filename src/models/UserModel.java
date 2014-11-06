package models;

import businessLogic.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jmarquez on 10/20/2014.A
 */
public class UserModel {

    private int userId;
    private String createDate;
    private String firstName;
    private String lastName;
    //private String username;
    //private String password;
    //private String address;
    //private String phoneNumber;
    //private String dateOfBirth;
    //private String gender;
    private boolean isAdmin;
    private Enums.UserType userType;
    private int accountId;


//    public UserModel(String username, String password, int userId, boolean isAdmin,
//                     String firstName, String lastName, String address, String phoneNumber, String DOB, String gender) {
        public UserModel(String firstName, String lastName) {
        this.userId = 1;        //todo needs to be a value from the database
        this.firstName = firstName;
        this.lastName = lastName;
        createDate = Utilities.getCurrentDate();
            this.accountId = -1;
    }

    public UserModel()
    {
        //return new UserModel();
    }

    public UserModel(int userId)
    {    this.userId = userId;
    }

    public int getUserId()
    {
        return userId;
    }

    //@precondition: this method has been called
    //@postcondition: user’s first name is set
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    //@precondition: this method has been called
    //@postcondition: the user’s last name is set
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    public void setCreateDate(String createDate)
    {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setUserType(String userType)
    {
        this.userType = Enums.UserType.valueOf(userType);
    }

    public Enums.UserType getUserType()
    {
        return userType;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public boolean isAdmin()
    {
        return userType == Enums.UserType.ADMIN;
    }

}
