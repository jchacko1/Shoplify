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

}
