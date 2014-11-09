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
    private double _discountAmount;
    private boolean _isSubscriptionOrder;
    public ShoppingCartModel _shoppingCart;
    private double _shippingFee;

    public OrderModel()
    {
        _shoppingCart = new ShoppingCartModel();
    }

    public double getShippingFee()
    {
        return _shippingFee;
    }

    public void setShippingFee(double shippingFee)
    {
       _shippingFee = shippingFee;
    }

    public double getDiscount()
    {
        return _discountAmount;
    }

    public void setDiscount(double discountAmount)
    {
        _discountAmount = discountAmount;
    }

    public double getOrderTotal()
    {
        return _orderTotal;
    }

    public void setOrderTotal()
    {
        _orderTotal = _subTotal + _tax - _discountAmount;
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
