package DataAccess;

import controllers.ItemController;
import controllers.OrderController;
import controllers.ReminderController;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemRepository extends BaseRepository {

    public ItemModel getItem(int itemId)
    {
        String itemName = "";
        double price = 0.0;
        int quantity = -1;
        String description = "";
        int categoryId = 1;
        int shoppingCartItemId = -1;
        String imagePath = "";
        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("begin Get Item table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Item where ItemId = " + itemId );
            while ( rs.next() ) {
                itemName = rs.getString("ItemName");
                price = rs.getDouble("price");
                quantity = rs.getInt("Quantity");
                description = rs.getString("Description");
                categoryId = rs.getInt("CategoryId");
                shoppingCartItemId = rs.getInt("ShoppingCartItemId");
                imagePath = rs.getString("ImagePath");
                System.out.println( "ItemName = " + itemName );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        if(itemName != null)
        {
            return new ItemModel(itemId,itemName,price,quantity,description, Enums.Category.values()[categoryId],shoppingCartItemId,imagePath);  //todo need to get the item from the database
        }
        return null;
    }

    public ArrayList<ReminderModel> getShoppingList(int userId)
    {
        //TODO get a "shopping list based on userId

        ArrayList<ReminderModel> shoppingList = new ArrayList<ReminderModel>();
       /* shoppingList.add(new ItemModel(1,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null));
        shoppingList.add(new ItemModel(2,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null));
        shoppingList.add(new ItemModel(3,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null));*/

        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin get ShoppingList table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select * from ShoppingList where UserId = " + String.valueOf(userId) + ";");
            while ( rs.next() ) {
                userId  = rs.getInt("UserId");
                System.out.println( "UserId = " + userId );
                //shoppingList.add(ReminderController);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        //return orders;

        return shoppingList;
    }

    public void addItemToShoppingList(int ItemId, int ShoppingListId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin add Item to ShoppingListItems table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "INSERT INTO ShoppingListItems(ShoppingListId, ItemId) values(" + ShoppingListId + "," + "Item Id" + ItemId + ");");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

    }

    //TODO: how can we delete item from shoppingListItems table?
    public void deleteItemFromShoppingList(int itemId, int shoppingListId)
    {

    }


    //TODO: we need userId or orderId?
    public ArrayList<ItemModel> getOrderItemsHistory(int orderId)
    {
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        Connection c = null;
        Statement stmt = null;
        int itemId = 0;
        try {
            System.out.println("begin get OrderItems for items table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select * from OrderItems where orderId = " + String.valueOf(orderId) + ";");
            while ( rs.next() ) {
                orderId  = rs.getInt("OrderId");
                itemId = rs.getInt("ItemID");
                System.out.println( "Order = " + orderId + "Item = " + itemId);
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


    /**
     * Get items from DB and return an arraylist
     * @return
     */
    public ArrayList<ItemModel> getItems()
    {
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();

        String itemName = "";
        double price = 0.0;
        int quantity = -1;
        String description = "";
        //Enums.Category category;
        int category;
        int shoppingCartItemId = -1;
        String imagePath = null;
        int itemId = 0;

        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("begin Item table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Item;");
            while ( rs.next() ) {
                itemId = rs.getInt("ItemId");

                itemName = rs.getString("ItemName");
                price = rs.getDouble("Price");
                quantity = rs.getInt("Quantity");
                description = rs.getString("Description");
               // System.out.print("Description");
                //category = (Enums.Category.values()[rs.getInt("CategoryId")]);
                category = rs.getInt("CategoryId");
                shoppingCartItemId = rs.getInt("ShoppingCartItemId");
                imagePath = rs.getString("ImagePath");

                //Add items from into list;
               // System.out.println( "ItemName = " + itemName + "ItemId = " + itemId + "Price = " + price + "Quantity = " + quantity + "Description = " + description + "Category" + category + "Shopping Cart Item id = "+ shoppingCartItemId + "Image path = " + imagePath );
               // System.out.println("ArrayList size  = " + items.size() + "Category Id = " + category);
                ItemModel itemModel = new ItemModel(itemId,itemName,price,quantity,description,Enums.Category.values()[category],shoppingCartItemId,imagePath);
                items.add(itemModel);


               // System.out.println("ArrayList size is =" + items.size());

            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        //return null;
       // return new ItemModel[]{new ItemModel(1,"Name",0.00,5,"Description", Enums.Category.Bread,-1)};
        return items;
    }

    public Set<Integer> getItemIdsByOrderIds( ArrayList<Integer> orderIds)
    {
        ArrayList<Integer> itemIds = new ArrayList<Integer>();
        int itemId = -1;
        Connection c = null;
        Statement stmt = null;
        for(int orderId : orderIds)
        {
            try {
                System.out.println("begin Get OrderItems by OrderIds table try block");
                Class.forName(getClassForName());
                c = DriverManager.getConnection(getConnectionString());
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM OrderItems where orderid = " + "'" + orderId +"'" + ";");
                while ( rs.next() ) {
                    itemId = rs.getInt("ItemId");
                    itemIds.add(itemId);
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("One loop of getting Items by OrderId done successfully");
        }

        Set<Integer> uniqueItemIds = new HashSet<Integer>(itemIds);
        return uniqueItemIds;
    }

    public ArrayList<ItemModel> getItemsOnSubscription(int subscriptionId)
    {
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        Connection c = null;
        Statement stmt = null;
        int itemId = 0;
        try {
            System.out.println("begin get Items on Subscription for items table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "Select * from SubscriptionItem where SubscriptionId = " + String.valueOf(subscriptionId) + ";");
            while ( rs.next() ) {
                ItemModel item = ItemController.getItem(rs.getInt("SubscriptionId"));
                item.setQuantity(rs.getInt("Quantity"));
                items.add(item);
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

    public void addItemToSubscription(int itemId, int quantity, int subscriptionId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin get OrderItems for items table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Insert Into SubscriptionItem(SubscriptionId, ItemId, Quantity) VALUES(= " + subscriptionId + "," + itemId + "," + quantity + ");");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void editItemInSubscription(int itemId, int quantity, int subscriptionId )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin edit item on Subscription try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Update SubscriptionItem set quantity = " + quantity + "where SubscriptionId = " + subscriptionId + "and ItemId = " + itemId + ";");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void deleteItemInSubscription(int itemId, int subscriptionId)
    {
            Connection c = null;
            Statement stmt = null;
            try {
                System.out.println("begin delete item on subscription try block");
                Class.forName(getClassForName());
                c = DriverManager.getConnection(getConnectionString());
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                stmt.executeUpdate( "Delete From SubscriptionItem where SubscriptionId = " + subscriptionId + "and ItemId = " + itemId + ";");
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");
    }

    public ItemDetailsModel getItemDetails(int itemId)
    {
        Connection c = null;
        Statement stmt = null;
        ItemDetailsModel itemDetailsModel = null;
        try {
            System.out.println("begin get Item Details try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ItemDetails where ItemId = " + itemId +";");
            while ( rs.next() ) {
                itemDetailsModel = new ItemDetailsModel(rs.getString("ItemIngredients"),rs.getInt("ItemCalories"),rs.getInt("ItemWeight"), rs.getString("ItemExpirationDate"), rs.getInt("IsItemReturnable") == 1);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return itemDetailsModel;
    }

}
