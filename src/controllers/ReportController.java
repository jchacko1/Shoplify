package controllers;

import businessLogic.ReportManager;
import models.*;
import global.Global;

/**
 * Created by Kelly An on 11/5/2014
 */
public class ReportController{

    private static ReportManager _reportManager = new ReportManager();

    public static ReportModel getReportWithLogin(String reportName, String reportId) {

        ReportModel reportModel = _reportManager.getReportWithLogin(reportName, reportId);
        //TODO: check the reportModel.getUserModel() to check the user type?
        if (reportModel != null) {

            //OrderModel orderModel = (OrderModel)reportModel.getReportId();

        }
        return reportModel;
    }

    public static void createReport(String reportId, String reportName) {

        //TODO: still need to check UserController to create a new user?
        UserModel userModel = new UserModel();
        ReportModel reportModel = _reportManager.createReport(reportName, reportId);

        if(reportModel != null) {
            reportModel.setUserModel(userModel);
            Global.currentReport = reportModel;
        }


    }

    public static void createReportAndItem(String itemName, String itemId, Double price,int quantity,String descritpion, Category category , String reportName, String reportId) {

        //TODO: call ItemController to create a new Item
        //ItemModel itemModel = new ItemModel(itemId,itemName,price, quantity, descritpion, category);


    }
}