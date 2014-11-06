package businessLogic;

import DataAccess.UserRepository;
import DataAccess.UserService;
import models.Enums;
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

    public UserModel createUser(String firstName, String lastName,String userType)
    {
        return _userService.createUser(firstName, lastName, userType);
    }

    public int createNewSubscription(int userId)
    {
        return _userService.createNewSubscription(userId);
    }
}
