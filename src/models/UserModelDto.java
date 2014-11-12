package models;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/11/2014.
 */
public class UserModelDto {
    public int _userId;
    public String _createDate;
    public String _firstName;
    public String _lastName;
    public boolean _isAdmin;
    public Enums.UserType _userType;
    public int _accountId;
    public String _address;
    public String _phoneNumber;
    public String _dateOfBirth;
    public String _gender;
    public String _email;
    ArrayList<ItemModel> _shoppingList;
    public int _subscriptionId;
    public boolean _canEditItems;
    public boolean _canEditUsers;
    public boolean _canRefundOrders ;

    public UserModelDto(int userId, String createDate, String firstName, String lastName, boolean isAdmin, Enums.UserType userType,
                        int accountId, String address, String phoneNumber, String dateOfBirth, String gender, String email, int subscriptionId, boolean canEditItems, boolean canEditUsers, boolean canRefundOrders)
    {
        _userId = userId;
        _createDate = createDate;
        _firstName = firstName;
        _lastName = lastName;
        _isAdmin = isAdmin;
        _userType = userType;
        _accountId = accountId;
        _address = address;
        _phoneNumber = phoneNumber;
        _dateOfBirth = dateOfBirth;
        _gender = gender;
        _email = email;
        _subscriptionId = subscriptionId;
        _canEditItems = canEditItems;
        _canEditUsers = canEditUsers;
        _canRefundOrders = canRefundOrders;
    }

    public Enums.UserType getUserType()
    {
        return _userType;
    }
}
