package models;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/3/2014.
 */
public class SubscriptionUserModel extends RegisteredUserModel {

    ArrayList<ItemModel> _shoppingList;
    private int _subscriptionId;

    public ArrayList<ItemModel> getShoppingList()
    {
        return _shoppingList;
    }

    public void setShoppingList(ArrayList<ItemModel> shoppingList)
    {
        _shoppingList = shoppingList;
    }

    public int getSubscriptionId()
    {
        return _subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId)
    {
        _subscriptionId = subscriptionId;
    }
}
