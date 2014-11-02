package businessLogic;

import models.UserModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserManager {

    public UserModel getUser(int userId)
    {
        //TODO get the user from the database with the userId
          return new UserModel(userId);
    }
}
