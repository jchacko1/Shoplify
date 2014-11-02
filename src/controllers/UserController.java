package controllers;

import businessLogic.UserManager;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserController {
    private static UserManager _userManager = new UserManager();

    public static models.UserModel getUser(int userId)
    {
          return _userManager.getUser(userId);
    }
}
