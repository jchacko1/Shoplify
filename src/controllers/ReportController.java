package controllers;

import DataAccess.ItemService;
import DataAccess.OrderService;
import DataAccess.ReportRepository;
import DataAccess.ReportService;
import businessLogic.ReportManager;
import models.*;
import global.Global;

/**
 * Created by Kelly An on 11/5/2014
 */
public class ReportController{

    private static ReportManager _reportManager = new ReportManager();
    private static ItemService _itemService = new ItemService();
    private static OrderService _orderService = new OrderService();


    public static ReportModel getReportWithLogin(String reportName, String reportId)
    {
        return _reportManager.getReportWithLogin(reportName, reportId);
    }

    public static void createReport(String reportId, String reportName) {

    }
}