package controllers;

import businessLogic.ItemManager;
import businessLogic.UserManager;
import global.Global;
import models.Enums;
import models.ItemModel;
import models.SubscriptionUserModel;
import models.UserModel;

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

    public static UserModel createUser(String firstname, String lastname, String userType)
    {
        return _userManager.createUser(firstname, lastname, userType);
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

            if(Global.currentAccount.getUserModel().getUserId() == userId)
            {
                //update the current User with the changes in this method
                subscriptionUserModel.setSubscriptionId(subscriptionId);
                subscriptionUserModel.setShoppingList(ItemController.getShoppingList(subscriptionId));
                Global.currentAccount.setUserModel(subscriptionUserModel);
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

            if(Global.currentAccount.getUserModel().getUserId() == userId)
            {
                //update the current User with the changes in this method
                subscriptionUserModel.setShoppingList(ItemController.getShoppingList(subscriptionId));
                Global.currentAccount.setUserModel(subscriptionUserModel);
            }
        }
    }

    public static ArrayList<ItemModel> getOrderItemsHistory(int userId)
    {
                     if(userId < 0)
                         {
                             //get the current User
                             return _itemManager.getOrderItemsHistory(Global.currentAccount.getUserId());
                         }
                     else
                         {
                             return _itemManager.getOrderItemsHistory(userId);
                         }
    }


}
