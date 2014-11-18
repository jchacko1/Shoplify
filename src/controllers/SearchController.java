package controllers;

import DataAccess.ItemService;
import businessLogic.ItemManager;
import businessLogic.SearchManager;
import models.Enums;
import models.ItemModel;
import models.SearchModel;

import java.util.ArrayList;

/**
 * Created by KellyAnn on 11/9/14.
 */
public class SearchController {
    private static SearchManager _searchManager = new SearchManager();
    private static ItemService _itemService = new ItemService();
    private static ItemManager _itemManager = new ItemManager();

    public static ArrayList<ItemModel> enterItemToSearch(String searchStr){
        // ArrayList<ItemModel> items = _searchManager.enterItemToSearch(searchStr);
        return  _searchManager.enterItemToSearch(searchStr);
    }


    //TODO: Do we need to cast the itemModel to searchModel? 11/17/2014
   /* public static SearchModel getItem(int itemId) {
        return _itemManager.getItem(itemId);
    }*/

    /**
     * Get item lists from ItemModel
     * @return
     */
    public static ArrayList<ItemModel> getItems(){
        return _itemManager.getItems();
    }

    /**
     * Get Category name and return an ArrayList
     * @return
     */
    public static ArrayList<String> getCategoryNames(){
        ArrayList<String> categoryNames = new ArrayList<String>();
        for (Enums.UserType userType : Enums.UserType.values()) {
            categoryNames.add(userType.toString());
        }
        return categoryNames;
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
