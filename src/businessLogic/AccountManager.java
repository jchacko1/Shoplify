package businessLogic;

import DataAccess.AccountService;
import DataAccess.ItemService;
import controllers.ItemController;
import controllers.UserController;
import models.*;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class AccountManager {
    private AccountService _accountService = new AccountService();

    public AccountManager()
    {

    }

    public AccountModel getAccountWithLogin(String login, String password)
    {
       AccountModel accountModel = _accountService.getAccount(login, password);
        if(accountModel != null)
        {
            UserModel userModel = UserController.getUser(accountModel.getUserId());
            accountModel.setUserModel(userModel);
        }
        return accountModel;
    }

    public AccountModel createAccount(String login, String password, int userTypeId)
    {
        return _accountService.createAccount(login, password, userTypeId);
    }

    public void updateUserIdOnAccount(int accountId, int userId)
    {
        _accountService.updateUserIdOnAccount(accountId, userId);
    }

    public AccountModel getAccountFromSecurityQuestion(String userName, int securityQuestionId, String securityQuestionAnswer)
    {   AccountModel accountModel =  _accountService.getAccountFromUserName(userName);
        if(accountModel != null)
        {
            UserModel userModel = UserController.getUser(accountModel.getUserId());
            //todo probably dont need to cast into subscription since registered users have a password
            RegisteredUserModel registeredUserModel = null;
            if(userModel.getUserType() == Enums.UserType.REGISTERED || userModel.getUserType() == Enums.UserType.SUBSCRIPTION)
            {
                registeredUserModel = (RegisteredUserModel)userModel;
                if(registeredUserModel.getSecurityQuestionId() == securityQuestionId && registeredUserModel.getSecurityAnswer().equalsIgnoreCase(securityQuestionAnswer))
                {
                    accountModel.setUserModel(registeredUserModel);
                }
                else
                {
                    //we didn't match the SecurityQuestionId and/or SecurityAnswer
                    System.out.println("SecurityQuestionId and/or SecurityAnswer don't match");
                    accountModel.setUserModel(null);
                }
            }
            else
            {
                //we didn't match up the UserModel
                System.out.println("We couldn't find the UserModel for the Account");
                accountModel.setUserModel(null);
            }
        }
        return accountModel;
    }
}
