package controllers;

import businessLogic.AccountManager;
import models.AccountModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class AccountController {
    private static AccountManager _accountManager = new AccountManager();

    public static AccountModel getAccountWithLogin(String login, String password)
    {
        return _accountManager.getAccountWithLogin(login, password);
    }
}
