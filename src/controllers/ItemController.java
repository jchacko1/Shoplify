package controllers;

import businessLogic.ItemManager;
import global.Global;
import models.*;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/3/2014.
 */
public class ItemController {
    private static ItemManager _itemManager = new ItemManager();

    public static ItemModel getItem(int itemId)
    {
        return _itemManager.getItem(itemId);
    }

    public static ArrayList<ItemModel> getShoppingList(int subscriptionId)
    {
        if(subscriptionId > 0)
        {
            return _itemManager.getShoppingList(subscriptionId);
        }
        return null;
    }

    public static ItemModel[] getItems(int orderId)
    {
        return _itemManager.getItems(orderId);
    }

    public static ArrayList<String> getCategoryNames(){
        ArrayList<String> categoryNames = new ArrayList<String>();
        for (Enums.UserType userType : Enums.UserType.values()) {
            categoryNames.add(userType.toString());
        }
        return categoryNames;
    }
}
