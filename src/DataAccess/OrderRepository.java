package DataAccess;

import controllers.ItemController;
import models.Enums;
import models.ItemModel;
import models.OrderModel;

import java.sql.*;
import java.util.ArrayList;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderRepository extends BaseRepository {

    public OrderModel getOrder(int orderId)
    {
        String orderName = "";
        double orderTotal = 0.0;
        double subTotal = 0.0;
        double tax = 0.0;
        double discountAmount = 0.0;
        boolean isSubscriptionOrder = false;
        double shippingFee = 0.0;
        int loggedInUserId = 0;
        //int quantity = -1;
       // String description = "";
       // int categoryId = 1;
      //  int shoppingCartItemId = -1;
        //String imagePath = "";
        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("begin Get Order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM UserOrder where OrderId = " + orderId );
            while ( rs.next() ) {
                /*itemName = rs.getString("ItemName");
                price = rs.getDouble("price");
                quantity = rs.getInt("Quantity");
                description = rs.getString("Description");
                categoryId = rs.getInt("CategoryId");
                shoppingCartItemId = rs.getInt("ShoppingCartItemId");
                imagePath = rs.getString("ImagePath");*/

                orderTotal = rs.getDouble("OrderTotal");
                subTotal = rs.getDouble("Subtotal");
                tax = rs.getDouble("Tax");
                discountAmount = rs.getDouble("DiscountAmount");
                isSubscriptionOrder = rs.getBoolean("IsSubscriptionOrder"); //TODO: use getBoolean or getInt?
                shippingFee = rs.getDouble("ShippingFee");
                loggedInUserId = rs.getInt("LoggedInUser");

                System.out.println( "OrderName = " + orderName );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        if(orderName != null)
        {
            return new OrderModel(orderId, orderTotal,subTotal,tax,loggedInUserId, discountAmount,isSubscriptionOrder,shippingFee);
        }
        return null;
    }

    public void submitOrder(OrderModel order)
    {
     //todo are we going to do anything with the database?
    }

    public int[] getOrderIds(int userId)
    {
        //todo get an array of OrderIds
        return new int[]{1,2,3};
    }

    public OrderModel createOrder(double orderTotal, double subTotal, double tax, int userId, double discountAmount, int isSubscriptionOrder, double shippingFee) throws ClassNotFoundException {
        Connection c = null;
        Statement stmt = null;
        int orderId = -1;

        try {
            System.out.println("begin Order create table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "INSERT INTO UserOrder(OrderTotal,Subtotal,Tax,UserId,DiscountAmount,IsSubscriptionOrder,ShippingFee) values(" + orderTotal + "," + subTotal + "," + tax + "," + userId + "," +discountAmount + "," +isSubscriptionOrder + "," + shippingFee + ");"  );
            ResultSet rs = stmt.executeQuery("select max(orderid) from userorder");
            while ( rs.next() ) {
                orderId = rs.getInt(1);
            }
            System.out.println( "OrderId = " + orderId );
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
            return new OrderModel(orderId,orderTotal,subTotal,tax,userId,discountAmount,isSubscriptionOrder == 1, shippingFee );
        }
        return null;
    }

    public void addItemToOrder(int orderId,int itemId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin add Item to Order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "INSERT INTO OrderItems(OrderId, ItemID) values(" + orderId + "," + itemId + ");");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void updateOrder(OrderModel order)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin Order Update table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            int resultId = stmt.executeUpdate( "Update UserOrder set OrderTotal = " + String.valueOf(order.getOrderTotal()) + ",Subtotal = " + String.valueOf(order.getSubTotal()) + ",Tax = " + String.valueOf(order.getTax()) +
               ",DiscountAmount = " + String.valueOf(order.getDiscount()) + ",ShippingFee = " + String.valueOf(order.getShippingFee()) + " where OrderId = " + String.valueOf(order.getOrderId()) + ";");
      //      while ( rs.next() ) {
                //String  name = rs.getString("name");
//                int age  = rs.getInt("age");
//                String  address = rs.getString("address");
//                float salary = rs.getFloat("salary");
//                System.out.println( "NAME = " + name );
//                System.out.println( "AGE = " + age );
//                System.out.println( "ADDRESS = " + address );
//                System.out.println( "SALARY = " + salary );
//                System.out.println();
            //}
            //rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public  ArrayList<ItemModel> getItemsOnOrder(int orderId)
    {
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        Connection c = null;
        Statement stmt = null;
        int itemId = -1;
        try {
            System.out.println("begin get OrderItems for order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select * from OrderItems where OrderId = " + String.valueOf(orderId) + ";");
           while ( rs.next() ) {
               itemId  = rs.getInt("ItemId");
                System.out.println( "Item = " + itemId );
               items.add(ItemController.getItem(itemId));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return items;
    }
}
