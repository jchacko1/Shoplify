package controllers;

import businessLogic.ItemManager;
import models.*;

import java.util.ArrayList;

/**
 * Created by KellyAnn on 11/13/14.
 */
public class ImageController {

    private static ItemManager _itemManager = new ItemManager();

    public static ItemModel[] getImages(int imageId){
        return _itemManager.getImages(imageId);
    }

    public static ArrayList<String> getCategoryNames(){
        ArrayList<String> categoryNames = new ArrayList<String>();
        for (Enums.UserType userType : Enums.UserType.values()) {
            categoryNames.add(userType.toString());
        }
        return categoryNames;
    }
}
