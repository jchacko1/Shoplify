package DataAccess;

import controllers.UserController;
import models.AccountModel;

/**
 * Created by jmarquez on 10/18/2014.
 */
public class AccountService {

    DataAccess.AccountRepository _accountRepository;

    public AccountService()
    {
        _accountRepository = new AccountRepository();
    }

    public void updateAccount(AccountModel accountModel)
    {
        _accountRepository.updateAccount(accountModel);
    }

    public AccountModel getAccount(int accountId)
    {
        return _accountRepository.getAccount(accountId);
    }

    public AccountModel getAccount(String login, String password)
    {
        AccountModel accountModel =  _accountRepository.getAccount(login, password);
        if(accountModel != null)
        {
            //set the user on the account
            accountModel.setUserModel(UserController.getUser(accountModel.getUserId()));
        }
        return accountModel;
    }

    public AccountModel createAccount(String login, String password,int userTypeId)
    {
        return _accountRepository.createAccount(login, password, userTypeId);
    }

}
