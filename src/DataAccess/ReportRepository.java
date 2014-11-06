package DataAccess;
import models.ReportModel;
import models.Enums;
import

/**
 * Created by Kelly An on 11/5/2014
 */
public class ReportRepository {

    public ReportModel getId(int report)
    {
        return new xReportModel(reportId);  //todo need to get the report id from the database
    }

    public ReportModel getName(int reportName)
    {
        return new ReportModel(reportName);  //todo need to get the report name from the database
    }

    public ReportModel checkAdminUser() {
        if(Global.currentAccount.getUserModel().getUserType == Enums.UserType.ADMIN)
        {
        //your code here

        }
    }
}