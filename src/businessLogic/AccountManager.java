package businessLogic;

import DataAccess.AccountService;
import DataAccess.ItemService;
import controllers.AccountController;
import controllers.ItemController;
import controllers.UserController;
import global.Global;
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

    public AccountModel getAccountFromUserName(String userName)
    {
        return _accountService.getAccountFromUserName(userName);
    }

    public AccountModel getAccountFromSecurityQuestion(String userName, int securityQuestionId, String securityQuestionAnswer)
    {   AccountModel accountModel =  getAccountFromUserName(userName);
        if(accountModel != null)
        {
            UserModel userModel = UserController.getUser(accountModel.getAccountUserModelId());
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

    public void logoutUser()
    {
        Global.CURRENT_ACCOUNT = null;
        Global.CURRENT_ORDER = null;
    }

    public AccountModel getGuestAccount()
    {
        AccountModel guestAccount = new AccountModel(-1,-1,"Guest","Password");
        return guestAccount;
    }

    public boolean createSubscription(String shipDate, boolean enabled, SubscriptionUserModel subscriptionUserModel)
    {
        return _accountService.createSubscription(shipDate, enabled, subscriptionUserModel);
    }

    public boolean updateSubscription(String shipDate, boolean enabled,SubscriptionUserModel subscriptionUserModel)
    {
        return _accountService.updateSubscription(shipDate,enabled,subscriptionUserModel);
    }

    public void insertSavedPaymentInformationModel(int userId, String creditCardType, String cardHoldersName, String creditCardNumber, String expirationDate, String cvs)
    {
        ArrayList<SavedPaymentInformationModel> savedPaymentInformationModels = _accountService.getSavedPayments(userId);
        boolean hasCreditCardAlreadyBeenSaved = false;
        for(SavedPaymentInformationModel savedPaymentInformationModel : savedPaymentInformationModels)
        {
            if(savedPaymentInformationModel.getCreditCardNumber() == creditCardNumber.trim())
            {
                hasCreditCardAlreadyBeenSaved = true;
            }
        }
        if(!hasCreditCardAlreadyBeenSaved)
        {
            _accountService.insertSavedPaymentInformationModel(userId, creditCardType, cardHoldersName, creditCardNumber.trim(), expirationDate.trim(),cvs);
        }
    }

    public ArrayList<SavedPaymentInformationModel> getSavedPayments(int userId)
    {
        return _accountService.getSavedPayments(userId);
    }

    public String getSubscriptionDate(int subscriptionId)
    {
       return _accountService.getSubscriptionDate(subscriptionId);
    }
}
