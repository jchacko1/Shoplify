package models;

import java.util.ArrayList;

/**
 * Created by KellyAnn on 11/9/14.
 */
public class SearchModel {

    private ArrayList<SearchModel> resultList;
    private int itemId;
    private String itemName;
    private Enums.Category category;
    private String searchStr;


    /**
     * Search model will take user search string
     * @param itemId
     * @param itemName
     * @param category
     * @param resultList
     */
    public SearchModel(int itemId, String itemName, Enums.Category category, ArrayList<SearchModel> resultList) {
       this.itemId = itemId;
       this.itemName = itemName;
       this.resultList = resultList;
       this.category = category;
    }

    /**
     * get user input search string and result list
     * @param searchStr
     * @param resultList
     */
    public SearchModel(String searchStr, ArrayList<SearchModel> resultList){
        this.searchStr = searchStr;
        this.resultList = resultList;
    }

    public String getSearchStr(){
        return searchStr;
    }

    public int getItemId(){
        return itemId;
    }

    public String getItemName(){
        return itemName;
    }

    public ArrayList<SearchModel> getResultList(){
        return resultList;
    }

    public void setSearchStr(String searchStr){
        this.searchStr = searchStr;
    }

    public void setItemsList(ArrayList<SearchModel> resultList){
        this.resultList = resultList;
    }

    public void setItemId(int itemId){
        this.itemId = itemId;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public void setCategory(Enums.Category category){
        this.category = category;
    }

}
