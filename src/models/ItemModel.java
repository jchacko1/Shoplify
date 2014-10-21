package models;

/**
 * Created by jmarquez on 10/20/2014.
 */
public class ItemModel {
    private int _itemId;
    private double _price;
    private int _quantity;
    private String _description;
    private Category _category;


    public enum Category {
     Meat,
     Dairy,
     Fruit,
     Vegetables,
     Drink,
     Dessert,
     Bread
    }
}


