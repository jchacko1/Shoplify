package DataAccess;

import controllers.ReportController;
import models.ReportModel;

/**
 * Created by Kelly An on 11/05/2014
 */
public class ReportService {

    DataAccess.ReportRepository _reportRepository;

    public ReportService() { _reportRepository = new ReportRepository(); }

   /* public void insertReport(ReportModel reportModel){
        _reportRepository.insertReport(reportModel);
    }*/

    public void updateReport(ReportModel reportModel)
    {
        _reportRepository.updateReport(reportModel);
    }

    public ReportModel getReport(int reportId)
    {
        return _reportRepository.getReport(reportId);
    }

    public ReportModel getReport(String reportName, String reportId)
    {
        ReportModel reportModel =  _reportRepository.getReport(reportName, reportId);
        if(reportModel != null)
        {
            //set the report on the account
        }
        return reportModel;
    }

    public ReportModel createReport(String reportName, String reportId)
    {
      return _reportRepository.createReport(reportName, reportId);
    }
}