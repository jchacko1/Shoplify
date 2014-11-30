package DataAccess;

import java.sql.*;
import models.DiscountModel;
import models.Enums;

import java.sql.Connection;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class DiscountRepository extends BaseRepository {


    public DiscountModel getDiscount(String discountCode)
    {
        Connection c = null;
        Statement stmt = null;
        int discountId = -1;
        double discountAmount = 0.00;
        boolean isDiscountInPercent = false;
        Enums.DiscountType discountType = null;
        int itemIdToDiscount = -1;

        try {
            System.out.println("begin get OrderIds by UserId order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select * from Discount where DiscountCode = " + "'" + discountCode + "'" + ";");
            while ( rs.next() ) {
                discountId  = rs.getInt("DiscountId");
                System.out.println( "DiscountId = " + discountId );
                discountAmount =  rs.getDouble("DiscountAmount");
                isDiscountInPercent = rs.getBoolean("IsDiscountInPercent");
                discountType = Enums.DiscountType.valueOf(rs.getString("DiscountType"));
                itemIdToDiscount =  rs.getInt("ItemIdToDiscount");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        if(discountId > -1)
        {
            return new DiscountModel(discountId,discountCode,discountAmount,isDiscountInPercent,discountType,itemIdToDiscount);
        }
        return null;
    }

    public int[] getDiscountIds(int discountId)
    {
        //TODO: get and array of discountIds
        return new int[]{1,2,3};
    }
}
