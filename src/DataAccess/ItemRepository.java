package DataAccess;

import models.Enums;
import models.ItemModel;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemRepository extends BaseRepository {

    //todo remove this if we dont need it anymore
    private static final int size = Enums.Category.values().length;

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

    public ArrayList<ItemModel> getShoppingList(int subscriptionId)
    {
        //todo get a "shopping list based on subscriptionId
        //todo the "shopping list" needs to come from the database

        ArrayList<ItemModel> shoppingList = new ArrayList<ItemModel>();
        shoppingList.add(new ItemModel(1,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null));
        shoppingList.add(new ItemModel(2,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null));
        shoppingList.add(new ItemModel(3,"Name",0.00,5,"Description", Enums.Category.Bread,-1, null));
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
        ItemModel modelOne = new ItemModel(1,"Name",0.00,5,"Description", Enums.Category.Bread,-1,null);
        ItemModel modelTwo = new ItemModel(2,"Name",0.00,5,"Description", Enums.Category.Bread,-1,null);
        ItemModel modelThree = new ItemModel(3,"Name",0.00,5,"Description", Enums.Category.Bread,-1,null);
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        items.add(modelOne);
        items.add(modelTwo);
        items.add(modelThree);
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

    public ItemModel[] getImages(int imageId)
    {
        //TODO: get an array of Images
        return new ItemModel[]{new ItemModel(1, "Name", 0.00,5,"Description", Enums.Category.Dairy,-1, 1,"Milk")};
    }


}
