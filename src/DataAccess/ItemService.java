package DataAccess;

import models.ItemDetailsModel;
import models.ItemModel;

import java.util.ArrayList;
import java.util.Set;

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


    public ArrayList<ItemModel> getShoppingList(int userId)
    {
       // return _itemRepository.getShoppingList(userId);
        return null;
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

  /*  public ItemModel[] getItems(int orderId)
    {
        return _itemRepository.getItems(orderId);
    }*/


    public ArrayList<ItemModel> getItems(){

        return _itemRepository.getItems();

    }

    public Set<Integer> getItemIdsByOrderIds( ArrayList<Integer> orderIds)
    {
         return _itemRepository.getItemIdsByOrderIds(orderIds);
    }

    public ArrayList<ItemModel> getItemsOnSubscription(int subscriptionId)
    {
        return _itemRepository.getItemsOnSubscription(subscriptionId);
    }

    public void addItemToSubscription(int itemId, int quantity, int subscriptionId)
    {
        _itemRepository.addItemToSubscription(itemId, quantity, subscriptionId);
    }

    public void editItemInSubscription(int itemId, int quantity, int subscriptionId )
    {
        _itemRepository.editItemInSubscription(itemId, quantity, subscriptionId);
    }

    public void deleteItemInSubscription(int itemId, int subscriptionId)
    {
        _itemRepository.deleteItemInSubscription(itemId, subscriptionId);
    }

    public ItemDetailsModel getItemDetails(int itemId)
    {
        return _itemRepository.getItemDetails(itemId);
    }

    public void adjustPriceOnItem(int itemId, double price)
    {
        _itemRepository.adjustPriceOnItem(itemId, price);
    }

    public void deleteItem(int itemId)
    {
        _itemRepository.deleteItem(itemId);
    }

    public void addItem(String itemName, double price, int quantity, String description, int categoryId, int shoppingCartItemId)
    {
        int newPrimaryKey = _itemRepository.getHighestPrimaryKey() + 1;
        String imagePath = "";
        switch(categoryId)
        {
            case(0):
                imagePath = "src/pics/Meat/ItemNotAvailable.jpg";
                break;
            case(1):
                imagePath = "src/pics/Dairy Product/ItemNotAvailable.jpg";
                break;
            case(2):
                imagePath = "src/pics/Fruit/ItemNotAvailable.jpg";
                break;
            case(3):
                imagePath = "src/pics/Vegetable/ItemNotAvailable.jpg";
                break;
            case(4):
                imagePath = "src/pics/Drink/ItemNotAvailable.jpg";
                break;
            case(5):
                imagePath = "src/pics/Desserts/ItemNotAvailable.jpg";
                break;
            case(6):
                imagePath = "src/pics/Bread/ItemNotAvailable.jpg";
                break;
        }
        _itemRepository.addItem(newPrimaryKey,itemName, price, quantity, description,categoryId,shoppingCartItemId, imagePath);
    }

    public void deleteItemsFromSubscription(int subscriptionId)
    {
        _itemRepository.deleteItemsFromSubscription(subscriptionId);
    }
}
