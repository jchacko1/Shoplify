package models;

import businessLogic.Utilities;

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
        _orderTotal = Utilities.round(orderTotal, 2);
        _subTotal = Utilities.round(subTotal, 2);
        _tax = Utilities.round(tax, 2);
        _loggedInUserId = loggedInUserId;
       _discountAmount = Utilities.round(discountAmount, 2);
       _isSubscriptionOrder = isSubscriptionOrder;
       _shippingFee = Utilities.round(shippingFee, 2);
        _shoppingCart = new ShoppingCartModel();
    }

    public double getShippingFee()
    {
        return _shippingFee;
    }

    public void setShippingFee(double shippingFee)
    {
       _shippingFee = Utilities.round(shippingFee, 2);
    }

    public double getDiscount()
    {
        return _discountAmount;
    }

    public void setDiscount(double discountAmount)
    {
        _discountAmount = Utilities.round(discountAmount, 2);
    }

    public double getOrderTotal()
    {
        return _orderTotal;
    }

    public void setOrderTotal()
    {
       Utilities.round(_orderTotal = _subTotal + _tax - _discountAmount, 2);
    }

    public void setSubTotal(){
        {
            double newSubtotal = 0.0;
            for(ItemModel item : _shoppingCart.getItems())
            {
                newSubtotal += item.getPrice();
            }
            _subTotal = Utilities.round(newSubtotal, 2);;
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
       Utilities.round( _tax = _taxPercentage * _subTotal, 2);
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
