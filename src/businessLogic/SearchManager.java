package businessLogic;

import DataAccess.ItemService;
import global.Global;
import models.Enums;
import models.ItemModel;
import models.SearchModel;

import java.util.ArrayList;


/**
 * Created by KellyAnn on 11/9/14.
 */
public class SearchManager {

    private ItemService _itemService = new ItemService();

    public ItemModel getItem(int itemId) {
        return _itemService.getItem(itemId);
    }

    /**
     * Get items ArrayList from itemService
     * @return
     */
    public ArrayList<ItemModel> getItems(){
        return _itemService.getItems();
    }

    /**
     * Enter the the itemName into search field
     * @param searchModel
     * @param itemModel
     */
    public void enterItemToSearch(SearchModel searchModel,ItemModel itemModel) {

    }
}
