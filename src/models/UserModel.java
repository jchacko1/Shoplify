package models;

import businessLogic.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jmarquez on 10/20/2014.A
 */
public class UserModel {

    private int _userId;
    private String _createDate;
    private String _firstName;
    private String _lastName;
    private boolean _isAdmin;
    private Enums.UserType _userType;
    private int _accountId;


    public UserModel()
    {
        //return new UserModel();
    }

    public UserModel(int userId, String createDate, String firstName, String lastName, boolean isAdmin, Enums.UserType userType, int accountId)
    {    _userId = userId;
         _createDate = createDate;
        _firstName = firstName;
        _lastName = lastName;
        _isAdmin = isAdmin;
        _userType = userType;
        _accountId = accountId;
    }

    public int getUserId()
    {
        return _userId;
    }

    public void setUserId(int userId)
    {
      _userId = userId;
    }

    //@precondition: this method has been called
    //@postcondition: user’s first name is set
    public void setFirstName(String firstName)
    {
        _firstName = firstName;
    }

    //@precondition: this method has been called
    //@postcondition: the user’s last name is set
    public void setLastName(String lastName)
    {
        _lastName = lastName;
    }


    public void setCreateDate(String createDate)
    {
        _createDate = createDate;
    }

    public String getCreateDate() {
        return _createDate;
    }

    public void setUserType(Enums.UserType userType)
    {
        _userType = userType;
    }

    public Enums.UserType getUserType()
    {
        return _userType;
    }

    public String getFirstName()
    {
        return _firstName;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public void setIsAdmin(boolean isAdmin)
    {
        _isAdmin = isAdmin;
    }

    public boolean getIsAdmin()
    {
        return _isAdmin;
    }

    public void setAccountId(int accountId)
    {
        _accountId = accountId;
    }

}
