package businessLogic;

//TODO: create ReportService inside DataAccess
import DataAccess.ReportService;
import controllers.ReportController;
import models.ReportModel;
import models.UserMode;
import controllers.UserController;

/**
 * Created by Kelly An on 11/5/2014
 */

public class ReportManager {
    private ReportService _reportService = new ReportService();

    public ReportManager()
    {

    }

    public

    private UserController _userController = new UserController();

    public ReportModel getReportWithLogin(String reportName, String reportId)
    {
        ReportModel reportModel = _reportService.getReport(reportName, reportId);
        if(reportModel != null)
        {
            UserModel userModel = _reportController.getReport(reportModel.getReportId());
            reportModel.setReportModel(reportModel);
        }
        return reportModel;
    }
}