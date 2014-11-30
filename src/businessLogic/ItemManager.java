package businessLogic;

import DataAccess.ItemService;
import controllers.ItemController;
import controllers.OrderController;
import global.Global;
import models.AccountModel;
import models.ItemDetailsModel;
import models.ItemModel;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemManager {
    private ItemService _itemService = new ItemService();

    public ItemModel getItem(int itemId)
    {
        return _itemService.getItem(itemId);
    }

    public ArrayList<ItemModel> getShoppingList(int shoppingListId)
    {
        return _itemService.getShoppingList(shoppingListId);
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

   /* public ItemModel[] getItems(int orderId)
    {
        return _itemService.getItems(orderId);
    }*/


    /**
     * Get items ArrayList from itemService
     * @return
     */
    public  ArrayList<ItemModel> getItems(){
        return _itemService.getItems();
    }

   // public ItemModel[] getImages(int imageId){ return _itemService.getImages(imageId); }

    public ArrayList<ItemModel> getItemsByUserId(int userId)
    {
        //first we need the OrderIds that the User has placed
        ArrayList<Integer> orderIds = OrderController.getOrderIdsByUserId(userId);

        //then we GET the itemIds from the OrderIds in OrderItems
        //we use Set because its constructor removes duplicates
        Set<Integer> itemIds = _itemService.getItemIdsByOrderIds(orderIds);

        //GET each item by itemId.
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        for(int itemId : itemIds)
        {
            items.add(getItem(itemId));
        }
        return items;
    }

    public ArrayList<ItemModel> getItemsOnSubscription(int subscriptionId)
    {
        return _itemService.getItemsOnSubscription(subscriptionId);
    }

    public String addItemToSubscription(int itemId, int quantity, int subscriptionId )
    {
        ItemModel itemToAdd = ItemController.getItem(itemId);
        ArrayList<ItemModel> itemsOnSubscription = getItemsOnSubscription(subscriptionId);
        if(itemToAdd.getQuantity() >= quantity)
        {
            for(ItemModel item : itemsOnSubscription)
            {
                if(item.getItemID() == itemId)
                {
                     return "Item already exists on the Subscription, please edit the quantity instead!";
                }
            }
            _itemService.addItemToSubscription(itemId, quantity, subscriptionId);
            return "Item added to Subscription!";
        }
        else
        {
            //not enough quantity available to add the item to the Subscription
            return "Not enough quantity available!";
        }
    }

    public void editItemInSubscription(int itemId, int quantity, int subscriptionId )
    {
        _itemService.editItemInSubscription(itemId, quantity, subscriptionId);
    }

    public void deleteItemInSubscription(int itemId, int subscriptionId)
    {
        _itemService.deleteItemInSubscription(itemId, subscriptionId);
    }

    public ItemDetailsModel getItemDetails(int itemId)
    {
        return _itemService.getItemDetails(itemId);
    }
}
