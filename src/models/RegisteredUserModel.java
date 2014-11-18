package models;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class RegisteredUserModel extends UserModel {

    private String _address;
    private String _phoneNumber;
    private String _dateOfBirth;
    private String _gender;
    private String _email;
    private int _securityQuestionId;
    private String _securityAnswer;

     public RegisteredUserModel(int userId, String createDate, String firstName, String lastName, boolean isAdmin, Enums.UserType userType, int accountId,
                                String address, String phoneNumber, String dateOfBirth, String gender, String email, int securityQuestionId, String securityAnswer){
         super.setUserId(userId);
         super.setCreateDate(createDate);
         super.setFirstName(firstName);
         super.setLastName(lastName);
         super.setIsAdmin(isAdmin);
         super.setUserType(userType);
         super.setAccountId(accountId);
         _address = address;
         _phoneNumber = phoneNumber;
         _dateOfBirth = dateOfBirth;
         _gender = gender;
         _email = email;
         _securityQuestionId = securityQuestionId;
         _securityAnswer = securityAnswer;
     }

    public RegisteredUserModel()
    {
        //
    }

    public void setSecurityQuestionId(int securityQuestionId)
    {
        _securityQuestionId =  securityQuestionId;
    }

    public int getSecurityQuestionId()
    {
        return _securityQuestionId;
    }

    public void setSecurityAnswer(String securityAnswer)
    {
        _securityAnswer =  securityAnswer;
    }

    public String getSecurityAnswer()
    {
        return _securityAnswer;
    }
    //@precondition: this method has been called
    //@postcondition: the user’s address is set
     public void setAddress(String address) {
        _address = address;
    }


    //@precondition: this method has been called
    //@postcondition: the user’s phone number is set
    public void setPhoneNumber(String phoneNumber) {
        _phoneNumber = phoneNumber;

    }


    //@precondition: this method has been called
    //@postcondition: the user’s date of birth is set
    public void setDateOfBirth(String DOB) {
        _dateOfBirth = DOB;
    }


    //@precondition: this method has been called
    //@postcondition: the user’s date of birth is set
    public void setGender(String gender) {
        _gender = gender;
    }


        public String getAddress() {
        return _address;
    }

    public String getPhoneNumber() {
        return _phoneNumber;
    }

    public void setEmail(String email)
    {
        _email = email;
    }

    public String getDateOfBirth() {
        return _dateOfBirth;
    }

    public String getGender() { return _gender;  }


}


