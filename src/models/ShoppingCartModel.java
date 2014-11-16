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
    private int quantity;

    //@precondition: none
//@postcondition: creates an empty shopping cart
    public ShoppingCartModel () {
        _items = new ArrayList<ItemModel>();
    }

    //@precondition: customer selects desired item
//@postcondition: adds item to the shopping cart
    public void addItem(ItemModel item){
        _items.add(item);
    }

   //@precondition: customer selects unwanted item
   //@postcondition: deletes item to the shopping cart
    public void deleteItem(ItemModel item){
        for(ItemModel itemToDelete : _items)
        if(itemToDelete.getShoppingCartItemId() == item.getShoppingCartItemId())
        {
            _items.remove(itemToDelete);
        }
    }


    //TODO lets keep subtotal on the order
    //@precondition: none
//@postcondition: displays the subtotal cost of all items in the shopping cart
    //public double getSubtotal(){
   //       return _subtotal;
    //}

    public ArrayList<ItemModel> getItems()
    {
        return _items;
    }

    public ItemModel getDiscountItem(int discountItemId)
    {
        for(ItemModel item : _items)
        {
            if (item.getItemID() == discountItemId)
            {
                return item;
            }
        }
        return null;
    }

    //@precondition: user inputs quantity
//@postcondition: item quantity adjusted to desired amount
    public void adjustQuantity(int quantity){
       // …
    }

}
