package controllers;

import businessLogic.AccountManager;
import global.Global;
import models.*;

import java.util.ArrayList;

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
            Global.currentAccount = accountModel;
        }
        return accountModel;
    }

    public static void createAccountAndUser(String login, String password, String firstName, String lastName,  String dateOfBirth,String gender, String address,String email, String phoneNumber, int securityQuestionId, String securityAnswer)
    {
        AccountModel accountModel = _accountManager.createAccount(login, password,2);
        RegisteredUserModel registeredUserModel = UserController.createRegisteredUser(firstName, lastName, dateOfBirth, gender,accountModel.getAccountId(), address, email,  phoneNumber, securityQuestionId,  securityAnswer); //todo call UserController to create a new User
        if(accountModel != null)
        {
            accountModel.setUserModel(registeredUserModel);
            Global.currentAccount = accountModel;
        }
    }

}
