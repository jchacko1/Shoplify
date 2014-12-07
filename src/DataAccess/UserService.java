package DataAccess;

import controllers.ItemController;
import controllers.UserController;
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

       if(userModelDto.getUserType() == Enums.UserType.GUEST)
        {
            return new UserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId);
        }
        else if(userModelDto.getUserType() == Enums.UserType.REGISTERED)
        {
            return new RegisteredUserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId,userModelDto._address,
                    userModelDto._phoneNumber, userModelDto._dateOfBirth,userModelDto._gender,userModelDto._email, userModelDto._securityQuestionId, userModelDto._securityAnswer);
        }
        else if(userModelDto.getUserType() == Enums.UserType.SUBSCRIPTION)
        {
            //ArrayList<ItemModel> shoppingList = ItemController.getShoppingList(userModelDto._subscriptionId);

            //TODO:Where is this shoppingListId from --> getShoppingListByUser
            ArrayList<UserModel> shoppingListByUser = ItemController.getShoppingListByUser(userId);

            SubscriptionUserModel subscriptionUserModel = new SubscriptionUserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId,userModelDto._address,
                    userModelDto._phoneNumber, userModelDto._dateOfBirth,userModelDto._gender,userModelDto._email,userModelDto._subscriptionId, userModelDto._securityQuestionId, userModelDto._securityAnswer);
            subscriptionUserModel.setShoppingListByUser(shoppingListByUser);

            return subscriptionUserModel;
        }
        else if(userModelDto.getUserType() == Enums.UserType.ADMIN)
        {
           return new AdminUserModel(userModelDto._userId,userModelDto._createDate,userModelDto._firstName,userModelDto._lastName,userModelDto._isAdmin,userModelDto._userType,userModelDto._accountId,userModelDto._address,
                   userModelDto._phoneNumber, userModelDto._dateOfBirth,userModelDto._gender,userModelDto._email,userModelDto._subscriptionId, userModelDto._canEditItems, userModelDto._canEditUsers, userModelDto._canRefundOrders);
        }
        return null;
    }

    public RegisteredUserModel createRegisteredUser(String firstName, String lastName, String dateOfBirth,String gender,int accountId, String address,String email, String phoneNumber, int securityQuestionId, String securityAnswer)
    {
        return _userRepository.createRegisteredUser(firstName, lastName,dateOfBirth,gender,accountId,address,email, phoneNumber,securityQuestionId,securityAnswer);
    }

    public int createNewSubscription(int userId)
    {
        return _userRepository.createNewSubscription(userId);
    }

    public boolean updateRegisteredUser(RegisteredUserModel registeredUserModel)
    {
        return _userRepository.updateRegisteredUser(registeredUserModel);
    }

    public boolean updateSubscriptionUser(SubscriptionUserModel subscriptionUserModel)
    {
        return _userRepository.updateSubscriptionUser(subscriptionUserModel);
    }

    public boolean isUserDisabled(int userId)
    {
        return _userRepository.isUserDisabled(userId);
    }
}
