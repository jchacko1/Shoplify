package DataAccess;

import models.OrderModel;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderRepository extends BaseRepository {

    public int submitOrder(OrderModel order)
    {
     //todo insert the Order record
     //todo insert records for each item ordered, into OrderItem. Associate the Items with a user
     //todo return the OrderId

        return 1;
    }

    public int[] getOrderIds(int userId)
    {
        //todo get an array of OrderIds
        return new int[]{1,2,3};
    }

    public void testSql() throws ClassNotFoundException {

        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("begin Order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM UserOrder;" );
            while ( rs.next() ) {
                int id = rs.getInt("OrderId");
                //String  name = rs.getString("name");
//                int age  = rs.getInt("age");
//                String  address = rs.getString("address");
//                float salary = rs.getFloat("salary");
                System.out.println( "ID = " + id );
//                System.out.println( "NAME = " + name );
//                System.out.println( "AGE = " + age );
//                System.out.println( "ADDRESS = " + address );
//                System.out.println( "SALARY = " + salary );
//                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
