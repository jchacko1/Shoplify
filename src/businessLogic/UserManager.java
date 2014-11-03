package businessLogic;

import DataAccess.UserRepository;
import DataAccess.UserService;
import models.UserModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserManager {
    private UserService _userService = new UserService();

    public UserModel getUser(int userId)
    {
        //TODO get the user from the database with the userId
          return new UserModel(userId);
    }
}
