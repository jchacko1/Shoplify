package businessLogic;

import DataAccess.ReminderService;
import models.ItemModel;
import models.ReminderModel;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class ReminderManager {

    private ReminderService _reminderService = new ReminderService();

   /* public ArrayList<ReminderModel> getReminderList(int reminderId){
        return _reminderService.getReminderList(reminderId);
    }*/

    public ArrayList<ItemModel> getReminderList(int reminderId)
    {
        return _reminderService.getReminderList(reminderId);
    }

    public void addItemToReminderList(ReminderModel reminderModel, ItemModel itemModel)
    {
        //_reminderService.addItemToReminderList(reminderModel, itemId);
        reminderModel.addItem(itemModel);
        itemModel.setReminderListItemId(Utilities.getRandomNumber());

    }

    public void deleteItemFromReminderList(ReminderModel reminderModel, ItemModel itemModel)
    {
       // _reminderService.deleteItemFromReminderList(reminderModel,itemId);
        reminderModel.deleteItem(itemModel);
    }

}
