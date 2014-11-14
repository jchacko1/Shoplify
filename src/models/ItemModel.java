package models;

/**
 * Created by jmarquez on 10/20/2014.
 */

//TODO: ItemModel match with itemImage?
public class ItemModel {
    private int itemId;
    private String itemName;
    private double price;
    private int quantity;
    private String description;
    private Enums.Category category;
    private int shoppingCartItemId;

    //item image match
    private int imageId;
    private String[] imageNames;
    private String imageName;



    public ItemModel(int itemId, String itemName, double price, int quantity, String description, Enums.Category category, int shoppingCartItemId){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.shoppingCartItemId = shoppingCartItemId;

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
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.shoppingCartItemId = shoppingCartItemId;
        this.imageId = imageId;
        this.imageName = imageName;
    }


    /**
     *
     * @return item's image id
     */
   public int getImageId(){
       return imageId;
   }

    /**
     *
     * @return item's image name
     */
   public String getImageName(){
       return imageName;
   }


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

//    public Category getCategory(){
//        return category;
//    }



    public void setItemID(int itemId){
        this.itemId = itemId;
    }

    public void setName(String itemName){
        this.itemName = itemName;
    }

    public void setPrice(double price){
        this.price = price;
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


