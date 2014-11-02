package businessLogic;

import DataAccess.AccountService;
import controllers.UserController;
import models.AccountModel;
import models.UserModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class AccountManager {
    private AccountService _accountService = new AccountService();

    public AccountManager()
    {

    }

    private UserController _userController = new UserController();

    public AccountModel getAccountWithLogin(String login, String password)
    {
       AccountModel accountModel = _accountService.getAccount(login, password);
        if(accountModel != null)
        {
            UserModel userModel = _userController.getUser(accountModel.getUserId());
            accountModel.setUserModel(userModel);
        }
        return accountModel;
    }

}
