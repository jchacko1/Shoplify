package models;

import java.util.List;

/**
 * Created by jmarquez on 10/20/2014.
 */
public class OrderModel {
    private int _orderId;
    private double _orderTotal;
    private double _subTotal;
    private double _tax;
    private int _loggedInUser;
    private double _discount;
    private boolean _isSubscriptionOrder;
    public ShoppingCartModel _shoppingCart;

    public OrderModel()
    {
        _shoppingCart = new ShoppingCartModel();
    }


}
