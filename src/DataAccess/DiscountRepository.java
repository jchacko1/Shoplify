package DataAccess;

import java.sql.*;
import models.DiscountModel;

import java.sql.Connection;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class DiscountRepository extends BaseRepository {

    public DiscountModel getDiscountModel(String promoCode)
    {
        if(true)
        {
         //todo get Discount from database, using the promoCode
         DiscountModel discountModel = new DiscountModel();
         return discountModel;
        }
        else
        {
            return null;
        }
    }

    public int[] getDiscountIds(int discountId)
    {
        //TODO: get and array of discountIds
        return new int[]{1,2,3};
    }

    /**
     * Test Discount DB syndication
     * @throws ClassNotFoundException
     */
    public void testSql() throws ClassNotFoundException {
        Connection c = null;
        Statement stmt = null;

        try{
            System.out.println("Begin Discount table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened Discount database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Discount;");

            while(rs.next()) {
                int id = rs.getInt("DiscountId");
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

        System.out.println("Discount DB Operation done successfully");

    }
}
