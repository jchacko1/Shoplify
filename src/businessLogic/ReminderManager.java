package businessLogic;

import DataAccess.ReminderService;
import models.ItemModel;
import models.ReminderModel;

import java.util.ArrayList;

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

    public void addItemToReminderList(int itemId, int reminderId)
    {
        _reminderService.addItemToReminderList(itemId, reminderId);
    }

    public void deleteItemFromReminderList(int itemId, int reminder)
    {
        _reminderService.deleteItemFromReminderList(itemId,reminder);
    }
}
