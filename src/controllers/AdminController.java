package controllers;

import businessLogic.AdminManager;
import models.AdminModel;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class AdminController {

    private static AdminManager _adminManager = new AdminManager();

    public static AdminModel getAdmin(int adminId){
        return _adminManager.getAdmin(adminId);
    }

    public static void adjustPriceOnItem(int itemId, double price)
    {
        _adminManager.adjustPriceOnItem(itemId, price);
    }

    public static void deleteItem(int itemId)
    {
        _adminManager.deleteItem(itemId);
    }

    public static void addItem(String itemName, double price, int quantity, String description, int categoryId, int shoppingCartItemId)
    {
        _adminManager.addItem(itemName, price, quantity, description,categoryId,shoppingCartItemId);
    }
}
