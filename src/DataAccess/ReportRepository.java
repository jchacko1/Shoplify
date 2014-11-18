package DataAccess;
import global.Global;
import models.OrderModel;
import models.ReportModel;
import models.Enums;

import java.sql.*;

/**
 * Created by Kelly An on 11/5/2014
 */
public class ReportRepository extends BaseRepository {

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

        if(Global.CURRENT_ACCOUNT.getUserModel().getUserType() == Enums.UserType.ADMIN)
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

    /**
     * Test Report DB syndication
     * @throws ClassNotFoundException
     */
    public void testSql() throws ClassNotFoundException {
        Connection c = null;
        Statement stmt = null;

        try{
            System.out.println("Begin Report table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened Report database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Report");

            while(rs.next()) {
                int id = rs.getInt("ReportId");
                System.out.println("ID = " + id);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        System.out.println("Report DB Operation done successfully");

    }
}