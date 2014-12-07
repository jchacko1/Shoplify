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

    public UserModel(String firstName, String lastName)
    {
        //return new UserModel();

        _firstName = firstName;
        _lastName = lastName;
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

    public int getUserTypeId()
    {
        if(_userType == Enums.UserType.GUEST)
        {
            return 0;
        }
        else if (_userType == Enums.UserType.REGISTERED)
        {
            return 1;
        }
        else if (_userType == Enums.UserType.SUBSCRIPTION)
        {
            return 2;
        }
        else if(_userType == Enums.UserType.ADMIN)
        {
            return 3;
        }
        //should never hit this part of the code
        return -1;
    }


    public int getAccountId()
    {
        return _accountId;
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
