package DataAccess;

import models.ItemModel;

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
}
