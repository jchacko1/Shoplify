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
    private int _loggedInUserId; //saved as 'LoggedInUser' in the UserOrder database
    private double _discountAmount;
    private boolean _isSubscriptionOrder;
    public ShoppingCartModel _shoppingCart;
    private double _shippingFee;

    public OrderModel()
    {
        _shoppingCart = new ShoppingCartModel();
    }

    public OrderModel(int orderId, double orderTotal, double subTotal, double tax, int loggedInUserId,double discountAmount, boolean isSubscriptionOrder, double shippingFee)
    {
       _orderId = orderId;
        _orderTotal = orderTotal;
        _subTotal = subTotal;
        _tax = tax;
        _loggedInUserId = loggedInUserId;
       _discountAmount = discountAmount;
       _isSubscriptionOrder = isSubscriptionOrder;
       _shippingFee = shippingFee;
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

    public void setSubTotal(){
        {
            double newSubtotal = 0.0;
            for(ItemModel item : _shoppingCart.getItems())
            {
                newSubtotal += item.getPrice();
            }
            _subTotal = newSubtotal;
        }
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

    public int getOrderId()
    {
        return _orderId;
    }

    public void updateAllPriceTotals()
    {
        setSubTotal();
        setTax();
        setOrderTotal();
    }
}
