package controllers;

import DataAccess.ItemService;
import businessLogic.SearchManager;
import models.ItemModel;
import models.SearchModel;

/**
 * Created by KellyAnn on 11/9/14.
 */
public class SearchController {
    private static SearchManager _searchManager = new SearchManager();
    private static ItemService _itemService = new ItemService();

    public static void enterItemToSearch(SearchModel search, int itemId){
        ItemModel itemModel = new ItemModel(itemId);
        _searchManager.enterItemToSearch(search, itemModel);
    }

    /**
     * TODO: need to check if the item is inside the DB or not
     * check the item is correct or not
     * @param search
     * @param itemId
     * @return
     */
    public static boolean checkItem(SearchModel search, int itemId) {
        return false;
    }
}
