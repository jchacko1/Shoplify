package DataAccess;

import models.Enums;
import models.UserModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserRepository {

    public UserModel getUser(int userId)
    {
        //TODO needs to be getting the userModel from the database, based on userId
        return new UserModel();
    }

    public UserModel createUser(String firstName, String lastName, String userType)
    {
        //TODO insert the UserModel into the database
        UserModel userModel = new UserModel();
                Enums.UserType userTypeOfNewUser;
                if(userType != null)
                {
                    userModel.setUserType(userType);
                }
         return userModel;
    }

    public int createNewSubscription(int userId)
    {
        int subscriptionId = 1; //todo this needs to be a primary key from the Subscription table
        return subscriptionId;
    }
}
