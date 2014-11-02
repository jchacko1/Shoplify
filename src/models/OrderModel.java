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
    private double _taxPercentage = 0.1;
    private int _loggedInUser;
    private double _discount;
    private boolean _isSubscriptionOrder;
    public ShoppingCartModel _shoppingCart;

    public OrderModel()
    {
        _shoppingCart = new ShoppingCartModel();
    }

    public double getDiscount()
    {
        return _discount;
    }

    public void setDiscount(double discountAmount)
    {
        _discount = discountAmount;
    }

    public double getOrderTotal()
    {
        return _orderTotal;
    }

    public void setOrderTotal()
    {
        _orderTotal = _subTotal + _tax + _discount;
    }

    public void setSubTotal()
    {
        _subTotal = _shoppingCart.getSubtotal();
    }

    public double getSubTotal()
    {
        return _subTotal;
    }

    public double getTax() {
        return _tax;
    }

    public void setTax()
    {
        _tax = _taxPercentage * _subTotal;
    }

    public void updateAllPriceTotals()
    {
        setSubTotal();
        setTax();
        setOrderTotal();
    }
}
