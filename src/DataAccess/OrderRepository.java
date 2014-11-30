package DataAccess;

import controllers.ItemController;
import models.Enums;
import models.ItemModel;
import models.OrderModel;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
        String orderDate = "";
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
                orderDate = rs.getString("OrderDate");
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
            return new OrderModel(orderId, orderTotal,subTotal,tax,loggedInUserId, discountAmount,isSubscriptionOrder,shippingFee,orderDate);
        }
        return null;
    }

    public void submitOrder(OrderModel order)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin Order Update from Submit Order try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Update UserOrder set IsOrderCompleted = 1,Address = " + "'" + order.getAddress() + "'" + ",City = " + "'" +  order.getCity() + "'" + ", State = " + "'" + order.getState() + "'" +
            ", ZipCode = " + "'" + order.getZipCode() + "'" + ", Country = " + "'" + order.getCountry() + "'" + ", PhoneNumber = " + "'" + order.getPhoneNumber() + "'" + ", Email = " + "'" + order.getEmail() + "'" +
            ", CreditCardType = " + "'" + order.getCreditCardType() + "'" + ", CardHoldersName = " + "'" + order.getCardHoldersName() + "'" + ", ExpirationDate = " + "'" + order.getExpirationDate() + "'" +
            ", Cvs = " + "'" + order.getCvs() + "'" + ", FirstNameOnOrder = " + "'" + order.getFirstNameOnOrder() + "'" + ", LastNameOnOrder = " + "'" + order.getLastNameOnOrder() + "'" + " OrderId = " + String.valueOf(order.getOrderId()) + ";");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
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
        int days = 2;
        Calendar calobj = Calendar.getInstance();
        calobj.add(Calendar.DAY_OF_MONTH, days);
        String date =  calobj.getTime().toString();
        try {
            System.out.println("begin Order create table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "INSERT INTO UserOrder(OrderTotal,Subtotal,Tax,UserId,DiscountAmount,IsSubscriptionOrder,ShippingFee, OrderDate) values(" + orderTotal + "," + subTotal + "," + tax + "," + userId + "," +discountAmount + "," +isSubscriptionOrder + "," + shippingFee + "," + date + ");"  );
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
            return new OrderModel(orderId,orderTotal,subTotal,tax,userId,discountAmount,isSubscriptionOrder == 1, shippingFee,date );
        }
        return null;
    }

    public void addItemToOrder(int orderId,int itemId, int shoppingCartItemId, int quantity)
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
            stmt.executeUpdate( "INSERT INTO OrderItems(OrderId, ItemID, ShoppingCartItemId, Quantity) values(" + orderId + "," + itemId + "," + shoppingCartItemId + "," + quantity + ");");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public int getMaxShoppingCartItemIdOnOrder(int orderId)
    {
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        Connection c = null;
        Statement stmt = null;
        int shoppingCartItemId = -1;
        try {
            System.out.println("begin get ShoppingCartItemId for OrderItems table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select max(ShoppingCartItemId) from OrderItems where OrderId = " + String.valueOf(orderId) + ";");
            while ( rs.next() ) {
                shoppingCartItemId  = rs.getInt("ItemId");
                System.out.println("ShoppingCartItemId = " + shoppingCartItemId);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return shoppingCartItemId;
    }

    public void editItemOnOrder(int orderId,int itemId,int shoppingCartItemId,int quantity)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin Edit Item on Order try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Update OrderItems set Quantity = " + quantity +  " where OrderId = " + orderId + " and ItemID = " + itemId + " and ShoppingCartItemId = " + shoppingCartItemId + ";");

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
               ",DiscountAmount = " + String.valueOf(order.getDiscount()) + ",ShippingFee = " + String.valueOf(order.getShippingFee()) + ",OrderDate = " + String.valueOf(order.getOrderDate())  + " where OrderId = " + String.valueOf(order.getOrderId()) + ";");
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
        int shoppingCartItemId = -1;
        int quantity = -1;
        ItemModel itemModel;
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
               shoppingCartItemId = rs.getInt("ShoppingCartItemId");
               System.out.println( "ShoppingCartItemId = " + shoppingCartItemId );
               quantity = rs.getInt("Quantity");
               itemModel = ItemController.getItem(itemId);
               itemModel.setQuantity(quantity);
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

        //TODO *Should* sort the ItemModels in items, by ShoppingCartItemId, so that we can show the items in the order they have been added
        Collections.sort(items);
        return items;
    }

    public void deleteItemOnOrder(int orderId,int itemId,int shoppingCartItemId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin Delete from OrderItems for order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.execute("Delete from OrderItems where OrderId = " + String.valueOf(orderId) + "and ItemID = " + String.valueOf(itemId) + "and ShoppingCartItemId = " + String.valueOf(shoppingCartItemId) + ";");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public ArrayList<Integer> getOrderIdsByUserId(int userId)
    {
        ArrayList<Integer> orderIds = new ArrayList<Integer>();
        Connection c = null;
        Statement stmt = null;
        int orderId = -1;
        try {
            System.out.println("begin get OrderIds by UserId order table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select OrderId from UserOrder where UserId = " + String.valueOf(userId) + ";");
            while ( rs.next() ) {
                orderId  = rs.getInt("OrderId");
                System.out.println( "OrderId = " + orderId );
                orderIds.add(orderId);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return orderIds;
    }

}
