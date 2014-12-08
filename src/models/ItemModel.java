package models;

import businessLogic.Utilities;

import java.util.ArrayList;

/**
 * Created by jmarquez on 10/20/2014.
 */

//TODO: ItemModel match with itemImage?
public class ItemModel implements Comparable<ItemModel> {
    private int itemId;
    private String itemName;
    private double price;
    private int quantity;
    private String description;
    private Enums.Category category;
    private int shoppingCartItemId;
    private int reminderListItemId;

    //item image match
    private int imageId;
    private String[] imageNames;
    private String imageName;
    private String imagePath;

    private ArrayList<ItemModel> itemsList;


    public ItemModel(int itemId, String itemName, double price, int quantity, String description, Enums.Category category, int shoppingCartItemId, String imagePath){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = Utilities.round(price, 2);
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.shoppingCartItemId = shoppingCartItemId;
        this.imagePath = imagePath;

    }

    @Override
    public int compareTo(ItemModel comparestu) {
        int compareage=((ItemModel)comparestu).getShoppingCartItemId();
        /* For Ascending order*/
        return this.shoppingCartItemId-compareage;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }

    /**
     * Get Item with Image
     * @param itemId
     * @param itemName
     * @param price
     * @param quantity
     * @param description
     * @param category
     * @param shoppingCartItemId
     * @param imageId
     * @param imageName
     */
    public ItemModel(int itemId, String itemName, double price, int quantity, String description, Enums.Category category, int shoppingCartItemId, int imageId, String imageName){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = Utilities.round(price, 2);;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.shoppingCartItemId = shoppingCartItemId;
        this.imageId = imageId;
        this.imageName = imageName;
    }


    /**
     * Get image path
     * @return
     */
    public String getImagePath(){
        return imagePath;
    }


    /**
     *
     * @return item's image id
     */
   public int getImageId(){
       return imageId;
   }


   public int getReminderListItemId() { return reminderListItemId; }

   public void setReminderListItemId(int id) { reminderListItemId = id; }

   public int getShoppingCartItemId() {
        return shoppingCartItemId;
    }

    public void setShoppingCartItemId(int id)
    {
        shoppingCartItemId = id;
    }

    //@precondition: none
    //@postcondition: returns item number
    public int getItemID() {
        return itemId;
    }


    //@precondition: none
    //@postcondition: returns item name
    public String getName(){
        return itemName;
    }


    //@precondition: none
    //@postcondition: item price returned
    public double getPrice(){
        return price;
    }


    //@precondition: none
    //@postcondition: item quantity returned
    public int getQuantity(){
        return quantity;
    }

    public String getDescription(){
        return description;
    }

    public Enums.Category getCategory(){
        return category;
    }

    /**
     * Get the list of item
     * @return
     */
    public ArrayList<ItemModel> getItemsList(){
        return itemsList;
    }

    /**
     * Set items list to an arraylist
     * @param itemsList
     */
    public void setItemsList(ArrayList<ItemModel> itemsList){
        this.itemsList = itemsList;
    }



    public void setItemID(int itemId){
        this.itemId = itemId;
    }

    public void setName(String itemName){
        this.itemName = itemName;
    }

    public void setPrice(double price){
        this.price = Utilities.round(price, 2);;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCategory(Enums.Category category){
        this.category = category;
    }

    public void setImageId(int imageId){
        this.imageId = imageId;
    }

    public void setImageName(String imageName){
        this.imageName = imageName;
    }

}


