package models;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/3/2014.
 */
public class SubscriptionUserModel extends RegisteredUserModel {

    ArrayList<ItemModel> _shoppingList;
    private int _subscriptionId;

    public SubscriptionUserModel(int userId, String createDate, String firstName, String lastName, boolean isAdmin, Enums.UserType userType, int accountId,
                                 String address, String phoneNumber, String dateOfBirth, String gender, String email, int subscriptionId, int securityQuestionId, String securityAnswer)
    {
        super.setUserId(userId);
        super.setCreateDate(createDate);
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setIsAdmin(isAdmin);
        super.setUserType(userType);
        super.setAccountId(accountId);
        super.setAddress(address);
        super.setPhoneNumber(phoneNumber);
        super.setDateOfBirth(dateOfBirth);
        super.setGender(gender);
        super.setEmail(email);
        super.setSecurityQuestionId(securityQuestionId);
        super.setSecurityAnswer(securityAnswer);
        _subscriptionId = subscriptionId;
    }

    public SubscriptionUserModel()
    {
        //
    }

    public ArrayList<ItemModel> getShoppingList()
    {
        return _shoppingList;
    }

    public void setShoppingList(ArrayList<ItemModel> shoppingList)
    {
        _shoppingList = shoppingList;
    }

    public int getSubscriptionId()
    {
        return _subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId)
    {
        _subscriptionId = subscriptionId;
    }
}
