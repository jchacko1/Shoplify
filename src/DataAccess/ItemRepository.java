package DataAccess;

import models.ItemModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class ItemRepository {

    public ItemModel getItem(int itemId)
    {
        return new ItemModel(itemId);  //todo need to get the item from the database
    }
}
