package DataAccess;

import controllers.UserController;
import models.AccountModel;
import models.SavedPaymentInformationModel;
import models.SubscriptionUserModel;
import models.UserModel;

import java.util.ArrayList;

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
            accountModel.setUserModel(UserController.getUser(accountModel.getAccountUserModelId()));
        }
        return accountModel;
    }

    public AccountModel createAccount(String login, String password,int userTypeId)
    {
        return _accountRepository.createAccount(login, password, userTypeId);
    }

    public void updateUserIdOnAccount(int accountId, int userId)
    {
        _accountRepository.updateUserIdOnAccount(accountId, userId);
    }

    public AccountModel getAccountFromUserName(String userName)
    {
        return _accountRepository.getAccountFromUserName(userName);
    }

    public boolean createSubscription(String shipDate, boolean enabled, SubscriptionUserModel subscriptionUserModel)
    {
        return _accountRepository.createSubscription(shipDate, enabled, subscriptionUserModel);
    }

    public boolean updateSubscription(String shipDate, boolean enabled,SubscriptionUserModel subscriptionUserModel)
    {
        return _accountRepository.updateSubscription(shipDate,enabled,subscriptionUserModel);
    }

    public void insertSavedPaymentInformationModel(int userId, String creditCardType, String cardHoldersName, String creditCardNumber, String expirationDate, String cvs)
    {
        _accountRepository.insertSavedPaymentInformationModel(userId, creditCardType, cardHoldersName, creditCardNumber, expirationDate,cvs);
    }

    public ArrayList<SavedPaymentInformationModel> getSavedPayments(int userId)
    {
        return _accountRepository.getSavedPayments(userId);
    }

    public String getSubscriptionDate(int subscriptionId)
    {
      return  _accountRepository.getSubscriptionDate(subscriptionId);
    }
}
