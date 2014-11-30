package DataAccess;

import controllers.ItemController;
import controllers.OrderController;
import models.ItemModel;
import models.OrderModel;
import models.ReturnModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class ReturnRepository extends BaseRepository{

    public void submitReturn(ReturnModel returnModel)
    {
        //Using upload file
    }

    public int[] getReturnId(int userId)
    {
        //TODO: get an array of Return Ids
        return new int[]{2, 3, 4};
    }

    public ReturnModel createReturn(int orderId, double orderTotal, int userId, int isSubscriptionOrder){
        Connection c = null;
        Statement stmt = null;
        int returnId = -1;
        try {
            System.out.println("begin ReturnOrder create table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "INSERT INTO ReturnOrder(OrderId, OrderTotal, UserId, IsSubscriptionOrder) values(" + userId + ","  + isSubscriptionOrder + ");"  );
            ResultSet rs = stmt.executeQuery("select max(orderid) from userorder");
            while ( rs.next() ) {
                orderId = rs.getInt(1);
            }
            System.out.println( "ReturnId = " + returnId );
            rs.close();
            stmt.close();
            c.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        if(orderId > -1)
        {
            return new ReturnModel(returnId,orderId,orderTotal,userId,isSubscriptionOrder == 1);
        }
        return null;
    }

    public void addOrderToReturn(int returnId, int orderId){
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin add Order to Return table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "INSERT INTO ReturnOrder(ReturnId, OrderId) values(" + returnId + "," + orderId + ");");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public ArrayList<OrderModel> getOrderOnReturn(int returnId)
    {
        ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
        Connection c = null;
        Statement stmt = null;
        int orderId = -1;
        try {
            System.out.println("begin get ReturnOrder for order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select * from ReturnOrder where ReturnId = " + String.valueOf(returnId) + ";");
            while ( rs.next() ) {
                orderId  = rs.getInt("OrderId");
                System.out.println( "Order = " + orderId );
                orders.add(OrderController.getOrder(orderId));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return orders;
    }
}
