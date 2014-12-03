package models;

/**
 * Created by jmarquez on 11/11/2014.
 */
public class AdminUserModel extends SubscriptionUserModel{
    private boolean _canEditItems;
    private boolean _canEditUsers;
    private boolean _canRefundOrders ;

    public AdminUserModel(int userId, String createDate, String firstName, String lastName, boolean isAdmin, Enums.UserType userType, int accountId,
                          String address, String phoneNumber, String dateOfBirth, String gender, String email, int subscriptionId, boolean canEditItems, boolean canEditUsers,
                          boolean canRefundOrders)
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
        super.setSubscriptionId(subscriptionId);
        _canEditItems = canEditItems;
        _canEditUsers = canEditUsers;
        _canRefundOrders = canRefundOrders;
    }

    public AdminUserModel()
    {

    }

    public boolean getCanEditItem()
    {
        return _canEditItems;
    }

    public boolean getCanEditUsers()
    {
        return _canEditUsers;
    }

    public boolean getCanRefundOrders()
    {
        return _canRefundOrders;
    }

}
