package models;

import businessLogic.Utilities;

import java.util.Date;

/**
 * Created by Kelly An on 11/05/2014
 */
public class ReportModel {

    private String reportId;
    private String reportName;
    private int userId;
    private String createDate;
    private int subscriptionId;
    private UserModel userModel;
    private ReportModel reportModel;


    public ReportModel(String reportName, String reportId)
    {
        this.reportName = reportName;
        this.userId = 1;
        createDate = Utilities.getCurrentDate();
    }

    public ReportModel() {

    }

    public ReportModel(String reportId){
        this.reportId = reportId;
    }

    public void setUserModel(UserModel userModel)
    {
        this.userModel = userModel;
    }

    /**
     * Get reporting id
     * @return
     */
    public String getReportId(){
        return reportId;
    }

    /**
     * Get reporting name
     * @return
     */
    public String getReportName(){
        return this.reportName;
    }

    public void setReportModel(ReportModel model){
        this.reportModel = model;
    }

}