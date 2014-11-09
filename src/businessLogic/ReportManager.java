package businessLogic;

//TODO: create ReportService inside DataAccess
import DataAccess.ReportService;
import controllers.ReportController;
import models.ReportModel;
import models.UserModel;
import controllers.UserController;

/**
 * Created by Kelly An on 11/5/2014
 */

public class ReportManager {
    private ReportService _reportService = new ReportService();
    //private ReportController _reportController = new ReportController();

    public ReportManager()
    {

    }


    private UserController _userController = new UserController();

    public ReportModel getReportWithLogin(String reportName, String reportId)
    {
        ReportModel reportModel = _reportService.getReport(reportName, reportId);
        if(reportModel != null)
        {
            reportModel = ReportController.getReportWithLogin(reportModel.getReportId(), reportModel.getReportName());
           // UserModel userModel = .getReport(reportModel.getReportId());
           // UserModel userModel = UserController.getUser(reportModel.getReportId());
            reportModel.setReportModel(reportModel);
        }
        return reportModel;
    }

    public ReportModel createReport(String reportName, String reportId){
        return _reportService.createReport(reportName, reportId);
    }
}