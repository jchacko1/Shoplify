package DataAccess;

import controllers.ItemController;
import models.Enums;
import models.ItemModel;
import models.SearchModel;

import java.sql.*;
import java.util.*;

/**
 * Created by KellyAnn on 11/17/14.
 */
public class SearchRepository extends BaseRepository{


  public ArrayList<SearchModel> getItems(){

    ArrayList<SearchModel> items = new ArrayList<SearchModel>();
    String itemName ="";
    //Enums.Category category;
    int category;
    int itemId = 0;
    String searchStr = "";

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

            //TODO: keep search string or item name?
            searchStr = rs.getNString("ItemName");

            itemId = rs.getInt("ItemId");
            itemName = rs.getString("ItemName");
            // System.out.print("Description");
            //category = (Enums.Category.values()[rs.getInt("CategoryId")]);
            category = rs.getInt("CategoryId");

            //Add items from into list;
            System.out.println( "ItemName = " + itemName + "ItemId = " + itemId  + "Category" + category);
            System.out.println("ArrayList size  = " + items.size() + "Category Id = " + category);

            //ItemModel itemModel = new ItemModel(itemId,itemName,price,quantity,description,Enums.Category.values()[category],shoppingCartItemId,imagePath);
            SearchModel searchModel = new SearchModel(itemId,itemName,Enums.Category.values()[category],items);

            SearchModel searchModel1 = new SearchModel(searchStr,items);

            items.add(searchModel);


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
}
