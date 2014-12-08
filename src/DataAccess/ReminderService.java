package DataAccess;

import businessLogic.ReminderManager;
import models.ItemModel;
import models.ReminderModel;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class ReminderService {
    DataAccess.ItemRepository _itemRepository;

    public ReminderService(){
        _itemRepository = new ItemRepository();
    }

    public ArrayList<ItemModel> getReminderList(int userId){

        return _itemRepository.getShoppingList(userId);

    }

    public void addItemToReminderList(int itemId, int reminderId)
    {
        _itemRepository.addItemToShoppingList(itemId, reminderId);
    }

    public void deleteItemFromReminderList(int itemId, int reminderId)
    {
        _itemRepository.deleteItemFromShoppingList(itemId,reminderId);
    }

    /**
     * TODO: how can we save the list with item into ShoppingList DB;
     * @param shoppingListId
     * @param itemId
     */
    public void saveCurrentList(int shoppingListId, int itemId){

        //TODO: how can we add the item into savelist
       // saveList.add(_itemRepository.addItemToShoppingList(itemId, shoppingListId));
        //_itemRepository.saveReminderList(shoppingListId, itemId);

    }

    public  ArrayList<ItemModel> getItemsOnReminderList(int shoppingListId){
        return _itemRepository.getItemsOnReminderList(shoppingListId);
    }
}
