package businessLogic;

import DataAccess.ItemService;
import models.AccountModel;
import models.ItemModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemManager {
    private ItemService _itemService = new ItemService();

    public ItemModel getItem(int itemId)
    {
        return _itemService.getItem(itemId);
    }

    public ArrayList<ItemModel> getShoppingList(int subscriptionId)
    {
        return _itemService.getShoppingList(subscriptionId);
    }

    public void addItemToShoppingList(int itemId, int subscriptionId)
    {
        _itemService.addItemToShoppingList(itemId, subscriptionId);
    }

    public void deleteItemFromShoppingList(int itemId, int subscriptionId)
    {
        _itemService.deleteItemFromShoppingList(itemId,subscriptionId);
    }

    public ArrayList<ItemModel> getOrderItemsHistory(int userId)
    {
        return _itemService.getOrderItemsHistory(userId);
    }

    public ItemModel[] getItems(int orderId)
    {
        return _itemService.getItems(orderId);
    }

    public ItemModel[] getImages(int imageId){ return _itemService.getImages(imageId); }

}
