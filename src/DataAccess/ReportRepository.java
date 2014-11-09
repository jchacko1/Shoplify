package DataAccess;
import global.Global;
import models.OrderModel;
import models.ReportModel;
import models.Enums;

/**
 * Created by Kelly An on 11/5/2014
 */
public class ReportRepository {

    public ReportModel getId(int report)
    {
        ReportModel model = new ReportModel();
        return model;  //todo need to get the report id from the database
    }

    public ReportModel getName(int reportName)
    {
        ReportModel model = new ReportModel();
        return model;  //todo need to get the report name from the database
    }

    public ReportModel checkAdminUser() {
        ReportModel model = new ReportModel();

        if(Global.currentAccount.getUserModel().getUserType() == Enums.UserType.ADMIN)
        {
            //your code here

        }
        return model;
    }

    public ReportModel createReport(String reportName, String reportId) {
        //TODO: create Report in database

        return new ReportModel();
    }

    public void updateReport(ReportModel reportModel) {

    }

    public ReportModel getReport(int orderId) {

        //TODO: build model from DB with orderId
        OrderModel model = new OrderModel();
        ReportModel reportModel = new ReportModel();
        return reportModel;

    }

    public ReportModel getReport(String reportName, String reportId) {

        //TODO: build model from DB with reportName and reportId
        ReportModel report = new ReportModel();
        return report;
    }
}