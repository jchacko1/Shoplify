package controllers;

import DataAccess.ItemService;
import businessLogic.ReminderManager;
import businessLogic.ShoppingCartManager;
import models.Enums;
import models.ItemModel;
import models.ReminderModel;
import models.ShoppingCartModel;

import java.util.*;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class ReminderController {
    // The master reminderList for the application.

    private static ReminderManager _reminderManager = new ReminderManager();
    private static ItemService _itemService = new ItemService();
    public static ArrayList<ReminderModel> reminderList;
    private ReminderModel reminder;

    /**
     * This class contains the master reminderList for the application.
     * This class is initialized in the ReminderGUI class.
     */
    public ReminderController() {
        reminderList = new ArrayList<ReminderModel>();
        //reminder = new ReminderModel(i, true, false, 100, new Date(System.currentTimeMillis()), SupplierController.supplierList.get(i));
        reminderList.add(reminder);
    }

    public static void addItemToList(ReminderModel reminderModel, int itemId)
    {   //todo get item from reminder list
        ItemModel itemModel = new ItemModel(itemId,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null); //todo needs to be a call to get an Item
        _reminderManager.addItemToReminderList(reminderModel, itemModel);
    }

    public static void deleteItemFromCart(ReminderModel reminderModel, int itemId)
    {   //todo get item from reminder list
        ItemModel itemModel = new ItemModel(itemId,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null); //todo needs to be a call to get an Item
        _reminderManager.deleteItemFromReminderList(reminderModel, itemModel);
    }



}
