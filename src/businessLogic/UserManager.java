package businessLogic;

import DataAccess.UserRepository;
import DataAccess.UserService;
import models.Enums;
import models.RegisteredUserModel;
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

    public RegisteredUserModel createRegisteredUser(String firstName, String lastName, String dateOfBirth,String gender,int accountId, String address,String email, String phoneNumber, int securityQuestionId, String securityAnswer)
    {
        return _userService.createRegisteredUser(firstName, lastName,dateOfBirth,gender,accountId, address,email, phoneNumber,securityQuestionId,securityAnswer);
    }

    public int createNewSubscription(int userId)
    {
        return _userService.createNewSubscription(userId);
    }
}
