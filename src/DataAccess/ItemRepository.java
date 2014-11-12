package DataAccess;

import models.Enums;
import models.ItemModel;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemRepository extends BaseRepository {

    public ItemModel getItem(int itemId)
    {
        return new ItemModel(itemId,"Name",0.00,5,"Description", Enums.Category.Bread);  //todo need to get the item from the database
    }

    public ArrayList<ItemModel> getShoppingList(int subscriptionId)
    {
        //todo get a "shopping list based on subscriptionId
        //todo the "shopping list" needs to come from the database

        ArrayList<ItemModel> shoppingList = new ArrayList<ItemModel>();
        shoppingList.add(new ItemModel(1,"Name",0.00,5,"Description", Enums.Category.Bread));
        shoppingList.add(new ItemModel(2,"Name",0.00,5,"Description", Enums.Category.Bread));
        shoppingList.add(new ItemModel(3,"Name",0.00,5,"Description", Enums.Category.Bread));
        return shoppingList;
    }

    public void addItemToShoppingList(int itemId, int subscriptionId)
    {
        //todo insert item into ShoppingList table
    }

    public void deleteItemFromShoppingList(int itemId, int subscriptionId)
    {
        //todo delete item from ShoppingList table
    }

    public ArrayList<ItemModel> getOrderItemsHistory(int userId)
    {
        //todo read from the database all items placed by a userId, in OrderItems table
        ItemModel modelOne = new ItemModel(1,"Name",0.00,5,"Description", Enums.Category.Bread);
        ItemModel modelTwo = new ItemModel(2,"Name",0.00,5,"Description", Enums.Category.Bread);
        ItemModel modelThree = new ItemModel(3,"Name",0.00,5,"Description", Enums.Category.Bread);
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        items.add(modelOne);
        items.add(modelTwo);
        items.add(modelThree);
        return items;
    }

    public ItemModel[] getItems(int orderId)
    {
        //todo get an array of items
        return new ItemModel[]{new ItemModel(1,"Name",0.00,5,"Description", Enums.Category.Bread)};
    }

    /**
     * Test Item DB syndication
     * @throws ClassNotFoundException
     */
    public void testSql() throws ClassNotFoundException {
        Connection c = null;
        Statement stmt = null;

        try{
            System.out.println("Begin Item table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened Item database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Item;");

            while(rs.next()) {
                int id = rs.getInt("ItemId");
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

        System.out.println("Item DB Operation done successfully");

    }

}
