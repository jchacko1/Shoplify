package DataAccess;

import businessLogic.ReminderManager;
import models.ItemModel;
import models.ReminderModel;


import java.util.ArrayList;

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
           return _itemRepository.getReminderList(reminderId);
       }
       return null;
    }

    public void addItemToReminderList(int itemId, int reminderId)
    {
        _itemRepository.addItemToReminderList(itemId, reminderId);
    }

    public void deleteItemFromReminderList(int itemId, int reminderId)
    {
        _itemRepository.deleteItemFromReminderList(itemId,reminderId);
    }

}
