package models;

import java.util.ArrayList;
/**
 * Created by jmarquez on 10/20/2014.
 */
public class ShoppingCartModel {
    //private int shoppingCartId;
    //private int orderId;
    private ArrayList cart = new ArrayList();
    private double total;
    private int quantity;

    //@precondition: none
//@postcondition: creates an empty shopping cart
    public ShoppingCartModel (ArrayList cart) {
       this.cart = cart;
    }

    //@precondition: customer selects desired item
//@postcondition: adds item to the shopping cart
    public void addItem(ItemModel item){
       cart.add(item);
    }

    //@precondition: customer selects unwanted item
//@postcondition: deletes item to the shopping cart
    public void deleteItem(ItemModel item){
        cart.remove(item);
    }

    //@precondition: none
//@postcondition: displays the total cost of all items in the shopping cart
    public double getTotal(){
        cart.get();


        }
    }

    //@precondition: user inputs quantity
//@postcondition: item quantity adjusted to desired amount
    public void adjustQuantity(int quantity){
        …
    }

}
