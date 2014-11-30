package models;

/**
 * Created by jmarquez on 11/30/2014.
 */
public class ItemDetailsModel {

    private String _itemIngredients;
    private int _itemCalories;
    private int _itemWeight;
    private String _itemExpirationDate;
    private boolean _isItemReturnable;

    public ItemDetailsModel(String itemIngredients, int itemCalories, int itemWeight, String itemExpirationDate, boolean isItemReturnable)
    {
         _itemIngredients = itemIngredients;
        _itemCalories = itemCalories;
        _itemWeight = itemWeight;
        _itemExpirationDate = itemExpirationDate;
        _isItemReturnable = isItemReturnable;
    }
}
