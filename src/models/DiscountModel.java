package models;

import global.Global;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class DiscountModel {
    private int _discountId;
    private String _discountCode;
    private double _discountAmount;
    private boolean _isDiscountInPercent;
    private Enums.DiscountType _discountType;
    private int _itemIdToDiscount;


    public DiscountModel(int discountId, String discountCode, double discountAmount, boolean isDiscountInPercent, Enums.DiscountType discountType, int itemIdToDiscount)
    {
       _discountId = discountId;
        _discountCode = discountCode;
        _discountAmount = discountAmount;
        _isDiscountInPercent = isDiscountInPercent;
        _discountType = discountType;
        _itemIdToDiscount = itemIdToDiscount;
    }

    public DiscountModel(){

    }

    public double getDiscountAmount()
    {
        return _discountAmount;
    }

    public int getDiscountItemId()
    {
        return _itemIdToDiscount;
    }

    public Enums.DiscountType getDiscountType()
    {
        return _discountType;
    }

    public boolean getIsDiscountInPercent()
    {
        return _isDiscountInPercent;
    }

    public double getFormattedDiscountedAmount()
    {
      return _isDiscountInPercent ? Global.CURRENT_ORDER.getSubTotal() * _discountAmount * -1 : _discountAmount * -1;
    }
}
