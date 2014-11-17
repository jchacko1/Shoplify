package models;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by KellyAnn on 11/9/14.
 */
public class SearchModel {

    private ArrayList<ItemModel> itemsList;
    private int itemId;
    private String itemName;
    private Enums.Category category;



    public SearchModel(int itemId, String itemName, Enums.Category category, ArrayList<ItemModel> itemsList) {
       this.itemId = itemId;
       this.itemName = itemName;
       this.itemsList = itemsList;
       this.category = category;
    }

    public int getItemId(){
        return itemId;
    }

    public String getItemName(){
        return itemName;
    }

    public ArrayList<ItemModel> getItemsList(){
        return itemsList;
    }

    public void setItemsList(ArrayList<ItemModel> itemsList){
        this.itemsList = itemsList;
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
