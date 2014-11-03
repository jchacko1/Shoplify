package businessLogic;

import DataAccess.ItemService;
import models.ItemModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemManager {
    private ItemService _itemService = new ItemService();

    public ItemModel getItem(int itemId)
    {
        return _itemService.getItem(itemId);
    }

}
