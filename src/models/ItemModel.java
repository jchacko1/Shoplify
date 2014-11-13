package models;

/**
 * Created by jmarquez on 10/20/2014.
 */
public class ItemModel {
    private int itemId;
    private String itemName;
    private double price;
    private int quantity;
    private String description;
    private Enums.Category category;
    private int shoppingCartItemId;


    public ItemModel(int itemId, String itemName, double price, int quantity, String description, Enums.Category category, int shoppingCartItemId){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.shoppingCartItemId = shoppingCartItemId;
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

}


