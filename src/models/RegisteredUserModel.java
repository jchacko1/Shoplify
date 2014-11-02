package models;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class RegisteredUserModel extends UserModel {
    private String username;
    private String password;
    private String address;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;



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
        this.dateOfBirth = DOB;
    }


    //@precondition: this method has been called
    //@postcondition: the user’s date of birth is set
    public void setGender(String gender) {
        this.gender = gender;
    }


        public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() { return gender;  }


}


