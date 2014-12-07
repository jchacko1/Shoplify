package businessLogic;

import DataAccess.UserRepository;
import DataAccess.UserService;
import models.Enums;
import models.RegisteredUserModel;
import models.SubscriptionUserModel;
import models.UserModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserManager {
    private UserService _userService = new UserService();

    public UserModel getUser(int userId)
    {
        return _userService.getUser(userId);
    }

    public UserModel getShoppingListByUser(int userId){
        return _userService.getUser(userId);
    }

    public RegisteredUserModel createRegisteredUser(String firstName, String lastName, String dateOfBirth,String gender,int accountId, String address,String email, String phoneNumber, int securityQuestionId, String securityAnswer)
    {
        return _userService.createRegisteredUser(firstName, lastName,dateOfBirth,gender,accountId, address,email, phoneNumber,securityQuestionId,securityAnswer);
    }

    public int createNewSubscription(int userId)
    {
        return _userService.createNewSubscription(userId);
    }

    public UserModel getGuestUser()
    {
        UserModel guestUser = new UserModel(-1,Utilities.getCurrentDate(),"Guest","User",false, Enums.UserType.GUEST,-1);
        return guestUser;
    }

    public boolean updateRegisteredUser(RegisteredUserModel registeredUserModel)
    {
            return _userService.updateRegisteredUser(registeredUserModel);
    }

    public boolean updateSubscriptionUser(SubscriptionUserModel subscriptionUserModel)
    {
        return _userService.updateSubscriptionUser(subscriptionUserModel);
    }

    public boolean isUserDisabled(int userId)
    {
       return _userService.isUserDisabled(userId);
    }
}
