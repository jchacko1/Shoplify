package DataAccess;

import controllers.ItemController;
import models.*;

import java.util.ArrayList;

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
        UserModelDto userModelDto = _userRepository.getUser(userId);
        RegisteredUserModel registeredUserModel = new RegisteredUserModel();

       if(userModelDto.getUserType() == Enums.UserType.GUEST)
        {
            return new UserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId);
        }
        else if(userModelDto.getUserType() == Enums.UserType.REGISTERED)
        {
            return new RegisteredUserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId,userModelDto._address,
                    userModelDto._phoneNumber, userModelDto._dateOfBirth,userModelDto._gender,userModelDto._email);
        }
        else if(userModelDto.getUserType() == Enums.UserType.SUBSCRIPTION)
        {
            ArrayList<ItemModel> shoppingList = ItemController.getShoppingList(userModelDto._subscriptionId);
            SubscriptionUserModel subscriptionUserModel = new SubscriptionUserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId,userModelDto._address,
                    userModelDto._phoneNumber, userModelDto._dateOfBirth,userModelDto._gender,userModelDto._email,userModelDto._subscriptionId);
            subscriptionUserModel.setShoppingList(shoppingList);
            return subscriptionUserModel;
        }
        else if(userModelDto.getUserType() == Enums.UserType.ADMIN)
        {
           return new AdminUserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId,userModelDto._address,
                   userModelDto._phoneNumber, userModelDto._dateOfBirth,userModelDto._gender,userModelDto._email,userModelDto._subscriptionId, userModelDto._canEditItems, userModelDto._canEditUsers, userModelDto._canRefundOrders);
        }
        return null;
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
