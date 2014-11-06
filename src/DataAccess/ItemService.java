package DataAccess;

import models.ItemModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemService {
    DataAccess.ItemRepository _itemRepository;

    public ItemService()
    {
        _itemRepository = new ItemRepository();
    }

    public ItemModel getItem(int itemId)
    {
        return _itemRepository.getItem(itemId);
    }

    public ArrayList<ItemModel> getShoppingList(int subscriptionId)
    {
        return _itemRepository.getShoppingList(subscriptionId);
    }

    public void addItemToShoppingList(int itemId, int subscriptionId)
    {
        _itemRepository.addItemToShoppingList(itemId, subscriptionId);
    }

    public void deleteItemFromShoppingList(int itemId, int subscriptionId)
    {
        _itemRepository.deleteItemFromShoppingList(itemId,subscriptionId);
    }

    public ArrayList<ItemModel> getOrderItemsHistory(int userId)
    {
        return _itemRepository.getOrderItemsHistory(userId);
    }
}
