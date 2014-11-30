package models;

import businessLogic.Utilities;
import global.Global;

import java.util.Calendar;
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
    private String _orderDate;
    private String _discountCode;

    //properties set when an order is submitted
    String _firstNameOnOrder;
    String _lastNameOnOrder;
    String _address;
    String _city;
    String _state;
    String _zipCode;
    String _country;
    String _phoneNumber;
    String _email;
    String _creditCardType;
    String _cardHoldersName;
    String _creditCardNumber;
    String _expirationDate;
    String _cvs;

    public OrderModel()
    {
        _shoppingCart = new ShoppingCartModel();
    }

    public OrderModel(int orderId, double orderTotal, double subTotal, double tax, int loggedInUserId,double discountAmount, boolean isSubscriptionOrder, double shippingFee, String orderDate)
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
        _orderDate = orderDate;
    }


    public void setAddress(String address)
    {
        _address = address;
    }

    public void setFirstNameOnOrder(String firstName)
    {
        _firstNameOnOrder = firstName;
    }

    public void setLastNameOnOrder(String lastName)
    {
        _lastNameOnOrder = lastName;
    }

    public void setCity(String city)
    {
        _city = city;
    }

    public void setState(String state)
    {
        _state = state;
    }

    public void setZipCode(String zipCode)
    {
        _zipCode = zipCode;
    }

    public void setCountry(String country)
    {
        _country = country;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        _phoneNumber = phoneNumber;
    }

    public void setEmail(String email)
    {
        _email = email;
    }

    public void setCreditCardType(String creditCardType)
    {
        _creditCardType = creditCardType;
    }

    public void setCardHoldersName(String cardHoldersName)
    {
        _cardHoldersName = cardHoldersName;
    }

    public void setCreditCardNumber(String creditCardNumber)
    {
        _creditCardNumber = creditCardNumber;
    }

    public void setExpirationDate(String expirationDate)
    {
        _expirationDate = expirationDate;
    }

    public void setCvs(String cvs)
    {
        _cvs = cvs;
    }

    public double getShippingFee()
    {
        return _shippingFee;
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

    public String getDiscountCode()
    {
        return _discountCode;
    }

    public void setDiscountCode(String discountCode)
    {
       _discountCode = discountCode;
    }

    public void setSubTotal(){
        {
            double newSubtotal = 0.0;
            for(ItemModel item : _shoppingCart.getItems())
            {
                newSubtotal += (item.getPrice() * item.getQuantity());
            }
            _subTotal = Utilities.round(newSubtotal, 2);
        }
    }

    public String getOrderDate()
    {
        return _orderDate;
    }

    public void setShippingFee()
    {
        if(getSubTotal() >= 50.00 || Global.CURRENT_ORDER.getDiscountCode() == "FreeShipping")
        {
            _shippingFee = 0;
        }
        else
        {
            _shippingFee = Utilities.round(Global.SHIPPING_FEE, 2);
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

    public String getCountry()
    {
        return _country;
    }

    public String getPhoneNumber()
    {
        return _phoneNumber;
    }

    public String getEmail()
    {
        return _email;
    }

    public String getCreditCardType()
    {
        return _creditCardType;
    }

    public String getCardHoldersName()
    {
        return _cardHoldersName;
    }

    public String getCreditCardNumber()
    {
        return _creditCardNumber;
    }

    public String getExpirationDate()
    {
        return _expirationDate;
    }

    public String getCvs()
    {
        return _cvs;
    }

    public String getFirstNameOnOrder()
    {
        return _firstNameOnOrder;
    }

    public String getLastNameOnOrder()
    {
        return _lastNameOnOrder;
    }

    public String getAddress()
    {
        return _address;
    }

    public String getCity()
    {
        return _city;
    }

    public String getState()
    {
        return _state;
    }

    public String getZipCode()
    {
        return _zipCode;
    }

    public void setOrderDate()
    {
        //set the OrderDate based on the number of items on the order
        int days = 2;
        int itemCount = 0;
        for(ItemModel item : _shoppingCart.getItems())
        {
            itemCount += item.getQuantity();
        }

        if(itemCount > 15)
        {
            days = 8;
        }
        else if (itemCount > 10)
        {
            days = 6;
        }
        else if (itemCount > 5)
        {
            days = 4;
        }

        Calendar calobj = Calendar.getInstance();
        calobj.add(Calendar.DAY_OF_MONTH, days);
        String date =  calobj.getTime().toString();
        _orderDate = date;
    }

    public void updateAllPriceTotals()
    {
        setSubTotal();
        setTax();
        setOrderTotal();
        setShippingFee();
    }
}
