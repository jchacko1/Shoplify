package DataAccess;

import models.ItemModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemRepository {

    public ItemModel getItem(int itemId)
    {
        return new ItemModel(itemId);  //todo need to get the item from the database
    }

    public ArrayList<ItemModel> getShoppingList(int subscriptionId)
    {
        //todo get a "shopping list based on subscriptionId
        //todo the "shopping list" needs to come from the database

        ArrayList<ItemModel> shoppingList = new ArrayList<ItemModel>();
        shoppingList.add(new ItemModel(1));
        shoppingList.add(new ItemModel(2));
        shoppingList.add(new ItemModel(3));
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
        ItemModel modelOne = new ItemModel(1);
        ItemModel modelTwo = new ItemModel(2);
        ItemModel modelThree = new ItemModel(3);
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        items.add(modelOne);
        items.add(modelTwo);
        items.add(modelThree);
        return items;
    }
}
