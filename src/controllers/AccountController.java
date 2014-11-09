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
        }
        return accountModel;
    }

    public static void createAccountAndUser(String firstName, String lastName, String login, String password)
    {
        UserModel userModel = new UserModel(); //todo call UserController to create a new User
        AccountModel accountModel = _accountManager.createAccount(login, password);
        if(accountModel != null)
        {
            accountModel.setUserModel(userModel);
            Global.currentAccount = accountModel;
        }
    }
}
