package controllers;

import businessLogic.AccountManager;
import global.Global;
import models.*;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class AccountController {
    private static AccountManager _accountManager = new AccountManager();

    public static AccountModel getAccountWithLogin(String login, String password)
    {
        AccountModel accountModel =  _accountManager.getAccountWithLogin(login, password);
        if(accountModel != null && accountModel.getUserModel().getUserType() == Enums.UserType.SUBSCRIPTION)
        {
            //todo move this logic into AccountManager
            SubscriptionUserModel subscriptionUserModel = (SubscriptionUserModel)accountModel.getUserModel();
            if(subscriptionUserModel.getSubscriptionId() > 0)
            {
                subscriptionUserModel.setShoppingList(ItemController.getShoppingList(subscriptionUserModel.getSubscriptionId()));
                accountModel.setUserModel(subscriptionUserModel);
            }
        }
        Global.CURRENT_ACCOUNT = accountModel;
        return accountModel;
    }

    public static boolean createAccountAndUser(String login, String password, String firstName, String lastName,  String dateOfBirth,String gender, String address,String email, String phoneNumber, int securityQuestionId, String securityAnswer)
    {
        //todo write logic to not insert a duplicate UserName
        AccountModel accountModel = _accountManager.createAccount(login, password,-1);
        RegisteredUserModel registeredUserModel = UserController.createRegisteredUser(firstName, lastName, dateOfBirth, gender,accountModel.getAccountId(), address, email,  phoneNumber, securityQuestionId,  securityAnswer); //todo call UserController to create a new User
        if(accountModel != null && registeredUserModel != null)
        {
            accountModel.setUserModel(registeredUserModel);
            updateUserIdOnAccount(accountModel.getAccountId(), registeredUserModel.getUserId());
            System.out.println("Log: createAccountAndUser done!");
            return true;
        }
        return false;
    }

    public static void updateUserIdOnAccount(int accountId, int userId)
    {
        _accountManager.updateUserIdOnAccount(accountId, userId);
    }

    public static AccountModel getAccountFromSecurityQuestion(String userName, int securityQuestionId, String securityQuestionAnswer)
    {
        return _accountManager.getAccountFromSecurityQuestion(userName, securityQuestionId, securityQuestionAnswer);
    }
}
