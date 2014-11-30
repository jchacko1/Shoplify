package controllers;

import businessLogic.ItemManager;
import businessLogic.UserManager;
import global.Global;
import models.*;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/3/2014.
 */
public class ItemController {
    private static ItemManager _itemManager = new ItemManager();
    private static UserManager _userManager = new UserManager();

    public static ItemModel getItem(int itemId)
    {
        return _itemManager.getItem(itemId);
    }

   // public static ArrayList<ItemModel> getItems() { return _itemManager.getItems(); }

    public static ArrayList<UserModel> getShoppingListByUser(int userId)
    {
        if(userId > 0)
        {
            //return _userManager.getShoppingListByUser(userId);
        }
        return null;
    }


    public static ArrayList<ItemModel> getShoppingListByItem(int shoppingListId){
        if(shoppingListId > 0) {
            return _itemManager.getShoppingList(shoppingListId);
        }
        return null;
    }

  /*  public static ItemModel[] getItems(int orderId)
    {
        return _itemManager.getItems(orderId);
    }*/

    /**
     *
     * select * from "item" , create a new itemModel, return an ArrayList of item
     * @return ItemModel arraylist
     */
    public static ArrayList<ItemModel> getItems(){

        return _itemManager.getItems();
    }


    public static ArrayList<String> getCategoryNames(){
        ArrayList<String> categoryNames = new ArrayList<String>();
        for (Enums.UserType userType : Enums.UserType.values()) {
            categoryNames.add(userType.toString());
        }
        return categoryNames;
    }
}
