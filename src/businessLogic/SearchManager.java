package businessLogic;

import DataAccess.ItemService;
import controllers.ItemController;
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
     * @param searchStr
     */
    public ArrayList<ItemModel> enterItemToSearch(String searchStr) {
        ArrayList<ItemModel> items = ItemController.getItems();
        ArrayList<ItemModel> resultSet = new ArrayList<ItemModel>();
        //String searchString = searchModel.getSearchStr().toLowerCase();

        for(ItemModel item : items)
        {
            int index = item.getName().toLowerCase().indexOf(searchStr);
            //add the item if we find the searchString in its name
            if (item.getName().toLowerCase().indexOf(searchStr) > -1)
            {
             resultSet.add(item);
            }
        }
        return resultSet;
    }
}
