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
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Item where ItemId = " + '"' + itemId + '"');
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
            ResultSet rs = stmt.executeQuery( "Select * from ShoppingList where UserId = " + '"' + String.valueOf(userId) + '"' + ";");
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
            stmt.executeUpdate( "INSERT INTO ShoppingListItems(ShoppingListId, ItemId) values(" + '"' + ShoppingListId + '"' + "," + '"' + ItemId + '"' + ");");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");

    }

    public void deleteItemFromShoppingList(int itemId, int shoppingListId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin delete item on shoppingListItems try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Delete From ShoppingListItems where ShoppingListId = " + '"' + shoppingListId + '"' + "and ItemId = " + '"' + itemId + '"' + ";");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

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
            ResultSet rs = stmt.executeQuery( "Select * from OrderItems where orderId = " + '"' +  String.valueOf(orderId) + '"' + ";");
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
                category = rs.getInt("CategoryId");
                shoppingCartItemId = rs.getInt("ShoppingCartItemId");
                imagePath = rs.getString("ImagePath");

                //Add items from into list;
               // System.out.println( "ItemName = " + itemName + "ItemId = " + itemId + "Price = " + price + "Quantity = " + quantity + "Description = " + description + "Category" + category + "Shopping Cart Item id = "+ shoppingCartItemId + "Image path = " + imagePath );
                ItemModel itemModel = new ItemModel(itemId,itemName,price,quantity,description,Enums.Category.values()[category],shoppingCartItemId,imagePath);
                items.add(itemModel);
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
            ResultSet rs = stmt.executeQuery( "Select * from SubscriptionItem where SubscriptionId = " + '"' + String.valueOf(subscriptionId) + '"' + ";");
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
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Insert Into SubscriptionItem(SubscriptionId, ItemId, Quantity) VALUES(" + '"' + subscriptionId + '"' + "," + '"' + itemId + '"' + "," + '"' + quantity + '"' + ");");
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
            stmt.executeUpdate( "Update SubscriptionItem set quantity = " + '"' + quantity + '"' + " where SubscriptionId = " + '"' + subscriptionId + '"' + " and ItemId = " + '"' + itemId + '"' + ";");
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
                stmt.executeUpdate( "Delete From SubscriptionItem where SubscriptionId = " + '"' + subscriptionId + '"' + " and ItemId = " + '"' + itemId + '"' + ";");
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
            ResultSet rs = stmt.executeQuery( "SELECT * FROM ItemDetails where ItemId = " + '"' + itemId + '"' +";");
            while ( rs.next() ) {
                String itemIngredients = rs.getString("ItemIngredients");
                System.out.println("ItemIngredients are: " + itemIngredients);
                int itemCalories = rs.getInt("ItemCalories");
                int itemWeight = rs.getInt("ItemWeight");
                String itemExpirationDate = rs.getString("ItemExpirationDate");
                boolean isItemReturnable = rs.getBoolean("IsItemReturnable");
                itemDetailsModel = new ItemDetailsModel(itemIngredients,itemCalories,itemWeight,itemExpirationDate,isItemReturnable);
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

    public void adjustPriceOnItem(int itemId, double price)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin update Item price try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String query = "Update Item set Price  = " + '"' + price + '"' + " where ItemId = " +  '"' + itemId + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void deleteItem(int itemId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin update Item price try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String query = "Update Item set Quantity = 0 where ItemId = " + '"' + itemId + '"' + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void addItem(int itemId, String itemName, double price, int quantity, String description, int categoryId, int shoppingCartItemId, String imagePath)
    {
        Connection c = null;
        Statement stmt = null;
        int accountId = -1;
        try {
            System.out.println("begin insert Item into Item table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String query = "Insert into Item(ItemId, ItemName, Price, Quantity,Description,CategoryId,ShoppingCartItemId,ImagePath)values(" + '"' + itemId + '"' + "," + '"'  + itemName + '"' + "," + '"' + price + '"' + "," + '"' + quantity + '"' + "," + '"' +
            description + '"' + "," + '"' + categoryId + '"' + ',' + '"' + shoppingCartItemId + '"' + "," + '"' + imagePath + '"' + ");";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public int getHighestPrimaryKey()
    {
        Connection c = null;
        Statement stmt = null;
        int highestPrimaryKey = -1;
        try {
            System.out.println("begin get highest primary key from Item table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select max(ItemId) from Item ;");
            while ( rs.next() ) {
                highestPrimaryKey = rs.getInt("max(ItemId)");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return highestPrimaryKey;
    }

    public void deleteItemsFromSubscription(int subscriptionId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin delete all items on subscription try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Delete From SubscriptionItem where SubscriptionId = " + '"' + subscriptionId + '"' + ";");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void addItemDetails(int newPrimaryKey,String itemIngredients,int itemCalories,int itemWeight,String itemExpirationDate,int isItemReturnable)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin insert Item Details table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String query = "Insert into ItemDetails(ItemId, ItemIngredients,ItemCalories,ItemWeight,ItemExpirationDate,IsItemReturnable)values(" + '"' + newPrimaryKey + '"' + "," + '"'  + itemIngredients + '"' + "," + '"' + itemCalories + '"' + "," + '"' + itemWeight + '"' + "," + '"' + itemExpirationDate + '"' + "," + '"' + isItemReturnable + '"' + ");";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void deleteItemDetails(int itemId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin delete item details for an item try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt.executeUpdate( "Delete From ItemDetails where ItemId = " + '"' + itemId + '"' + ";");
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }


}
