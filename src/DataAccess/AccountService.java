package DataAccess;

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

    public void insertAccount(AccountModel accountModel){
        _accountRepository.insertAccount(accountModel);
    }

    public void updateAccount(AccountModel accountModel)
    {
        _accountRepository.updateAccount(accountModel);
    }

    public AccountModel getAccount(int accountId)
    {
        return _accountRepository.getAccount(accountId);
    }

}
