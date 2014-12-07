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

    public ArrayList<ItemModel> getReminderList(int reminderId){
       if(reminderId > 0) {
           //return _itemRepository.getShoppingList(reminderId);
       }
       return null;
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
     * @param saveList
     * @param itemId
     */
    public void saveCurrentList(Collection<ItemModel> saveList, int itemId){

        //TODO: how can we add the item into savelist
       // saveList.add(_itemRepository.addItemToShoppingList(itemId, shoppingListId));
    }
}
