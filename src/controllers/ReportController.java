package controllers;

import DataAccess.ReportRepository;
import DataAccess.ReportService;
import bussinessLogic.ReportManager;
import models.ReportModel;

/**
 * Created by Kelly An on 11/5/2014
 */
public class ReportConroller{

    private static ReportManager _reportManager = new ReportManager();

    public static ReportModel getReportWithLogin(String reportName, String reportId)
    {
        return _reportManager.getReportWithLogin(reportName, reportId);
    }
}