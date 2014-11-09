package DataAccess;

import models.Enums;
import models.RegisteredUserModel;
import models.UserModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserService {

    DataAccess.UserRepository _userRepository;

    public UserService()
    {
        _userRepository = new UserRepository();
    }

    public UserModel getUser(int userId)
    {
        //TODO get the user from the database with the userId
        UserModel userModel = new UserModel(userId);
        RegisteredUserModel registeredUserModel = new RegisteredUserModel();

        if(userModel.getUserType() == Enums.UserType.REGISTERED)
        {
            userModel = registeredUserModel;
        }
        else if(userModel.getUserType() == Enums.UserType.SUBSCRIPTION)
        {
            //TODO fill in code for if a user is a subscription user
        }
        else if(userModel.getUserType() == Enums.UserType.ADMIN)
        {
            //TODO fill in code for if a user is a admin user
        }
            return userModel;
    }

    public UserModel createUser(String firstName, String lastName, String userType)
    {
        return _userRepository.createUser(firstName,lastName,userType);
    }

    public int createNewSubscription(int userId)
    {
        return _userRepository.createNewSubscription(userId);
    }
}
