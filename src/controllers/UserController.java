package controllers;

import businessLogic.ItemManager;
import businessLogic.UserManager;
import global.Global;
import models.*;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserController {
    private static UserManager _userManager = new UserManager();
    private static ItemManager _itemManager = new ItemManager();

    public static models.UserModel getUser(int userId)
    {
        return _userManager.getUser(userId);
    }

    public static RegisteredUserModel createRegisteredUser(String firstName, String lastName, String dateOfBirth,String gender,int accountId, String address,String email, String phoneNumber, int securityQuestionId, String securityAnswer)
    {
        return _userManager.createRegisteredUser(firstName,lastName,dateOfBirth,gender,accountId,address,email,phoneNumber,securityQuestionId,securityAnswer);
    }

    public static int createNewSubscription(int userId)
    {
        return _userManager.createNewSubscription(userId);
    }

    public static void addItemToShoppingList(int userId, int itemId) {
        UserModel userModel = _userManager.getUser(userId);
        if (userModel != null && userModel.getUserType() == Enums.UserType.SUBSCRIPTION) {

            SubscriptionUserModel subscriptionUserModel = (SubscriptionUserModel) userModel;
            int subscriptionId =    subscriptionUserModel.getSubscriptionId();
            if (subscriptionId > 0) {
                _itemManager.addItemToShoppingList(itemId, subscriptionUserModel.getSubscriptionId());
            } else {
                //create the new subscription
                subscriptionId = UserController.createNewSubscription(userId);
                _itemManager.addItemToShoppingList(itemId, subscriptionId);
            }

            if(Global.CURRENT_ACCOUNT.getUserModel().getUserId() == userId)
            {
                //update the current User with the changes in this method
                subscriptionUserModel.setSubscriptionId(subscriptionId);
                subscriptionUserModel.setShoppingList(ItemController.getShoppingList(subscriptionId));
                Global.CURRENT_ACCOUNT.setUserModel(subscriptionUserModel);
            }
        }
    }

    public static void deleteItemFromShoppingList(int itemId, int userId)
    {
        UserModel userModel = _userManager.getUser(userId);
        if (userModel != null && userModel.getUserType() == Enums.UserType.SUBSCRIPTION) {

            SubscriptionUserModel subscriptionUserModel = (SubscriptionUserModel) userModel;
            int subscriptionId =    subscriptionUserModel.getSubscriptionId();
            if (subscriptionId > 0) {
                _itemManager.deleteItemFromShoppingList(itemId, subscriptionId);
            }
            else{
                //user doesn't have a subscription
                return;
            }

            if(Global.CURRENT_ACCOUNT.getUserModel().getUserId() == userId)
            {
                //update the current User with the changes in this method
                subscriptionUserModel.setShoppingList(ItemController.getShoppingList(subscriptionId));
                Global.CURRENT_ACCOUNT.setUserModel(subscriptionUserModel);
            }
        }
    }

    public static ArrayList<ItemModel> getOrderItemsHistory(int userId)
    {
                     if(userId < 0)
                         {
                             //get the current User
                             return _itemManager.getOrderItemsHistory(Global.CURRENT_ACCOUNT.getUserId());
                         }
                     else
                         {
                             return _itemManager.getOrderItemsHistory(userId);
                         }
    }

    public static boolean isValidUser(UserModel userModel){

        if(userModel.getFirstName() == null ||
           userModel.getLastName() == null ||
           userModel.getUserId() == 0 ||
           userModel.getCreateDate() == null){
            return false;
        }
        if(userModel.getFirstName().isEmpty() || userModel.getLastName().isEmpty()) {
            return false;
        }
        //TODO: add checkemail and checkLogin method inside userModel?
        return true;

    }

    public static boolean checkLogin(String login){
        if(login == null)
            return false;
        return true;
    }


    public static boolean checkPassword(String password){
        if(password == null)
            return false;
        return true;
    }

    public static boolean checkEmail(String email){
        if(email == null)
            return false;
        return true;
    }


}
