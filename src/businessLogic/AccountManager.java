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
}
