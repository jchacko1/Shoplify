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

                subscriptionUserModel.setShoppingListByItem(ItemController.getShoppingListByItem(subscriptionUserModel.getSubscriptionId()));
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

    public static AccountModel getAccountFromUserName(String userName)
    {
        return _accountManager.getAccountFromUserName(userName);
    }

    public static void loginAsGuestUser()
    {
        //GET a Guest Account
        AccountModel accountModel = _accountManager.getGuestAccount();

        //GET a Guest User and attach it to the Account
         UserModel guestUser = UserController.getGuestUser();
         accountModel.setUserModel(guestUser);

        //attach the Account to the Global Account variable
        Global.CURRENT_ACCOUNT = accountModel;
    }

    public static void logoutUser()
    {
       _accountManager.logoutUser();
    }

    public static String createSubscription(String shipDate, boolean enabled, UserModel userModel)
    {
        if(userModel.getUserType() == Enums.UserType.REGISTERED || userModel.getUserType() == Enums.UserType.SUBSCRIPTION)
        {
            SubscriptionUserModel subscriptionUserModel = (SubscriptionUserModel)userModel;
                //stop a Subscription user from creating a subscription, they already have one
               if(subscriptionUserModel.getSubscriptionId() > -1)
               {
                  return "You have already created a Subscription!";
               }

            //create subscription
            if(_accountManager.createSubscription(shipDate, enabled, subscriptionUserModel))
            {
                //Set the user to a Subscription user, in case the User was originally a Registered User
                subscriptionUserModel.setSubscriptionUserType();

                //Update the user in the database with the new SubsriptionId and possibly a new UserType
                UserController.updateUser(subscriptionUserModel);

                return "Subscription created!";
            }
            else
            {
                return "Unable to create a subscription :(";
            }
        }
        else
        {
            //this is a guest or admin user
            return "Guest and Admin users cannot create a Subscription!";
        }
    }

    public static boolean updateSubscription(String shipDate, boolean enabled,SubscriptionUserModel subscriptionUserModel)
    {
        return _accountManager.updateSubscription(shipDate,enabled,subscriptionUserModel);
    }

    public static void insertSavedPaymentInformationModel(int userId, String creditCardType, String cardHoldersName, String creditCardNumber, String expirationDate, String cvs)
    {
      _accountManager.insertSavedPaymentInformationModel(userId, creditCardType, cardHoldersName, creditCardNumber, expirationDate,cvs);
    }

    public static ArrayList<SavedPaymentInformationModel> getSavedPayments(int userId)
    {
         return _accountManager.getSavedPayments(userId);
    }
}
