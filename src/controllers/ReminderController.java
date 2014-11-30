package controllers;

import models.ReminderModel;

import java.util.*;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class ReminderController {
    // The master reminderList for the application.
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

   // public static ReminderModel get


}
