package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmarquez on 10/20/2014.
 */
public class ShoppingCartModel {
    private int _shoppingCartId;
    private int _orderId;

    //public void addItem(ItemModel item)
    //{
      //  _items.add(item);
    //}
    //private int shoppingCartId;
    //private int orderId;
    private ArrayList<ItemModel> _items;
    private double total;
    private int quantity;

    //@precondition: none
//@postcondition: creates an empty shopping cart
    public ShoppingCartModel () {
       _items = new ArrayList<ItemModel>();
    }

    //@precondition: customer selects desired item
//@postcondition: adds item to the shopping cart
    public void addItem(ItemModel item){
        //cart.add(item);
    }

    //@precondition: customer selects unwanted item
//@postcondition: deletes item to the shopping cart
    public void deleteItem(ItemModel item)
    {
        //cart.remove(item);
    }

    //@precondition: none
//@postcondition: displays the total cost of all items in the shopping cart
    public double getTotal(){
        //cart.get();

          return 0.0;
        //}
    }

    //@precondition: user inputs quantity
//@postcondition: item quantity adjusted to desired amount
    public void adjustQuantity(int quantity){
       // …
    }

}
