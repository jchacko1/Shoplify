package businessLogic;

import DataAccess.ItemService;
import global.Global;
import models.DiscountModel;
import models.Enums;
import models.ItemModel;
import models.ShoppingCartModel;

/**
 * Created by jmarquez on 10/23/2014.
 */
public class ShoppingCartManager {
    private ItemService _itemService = new ItemService();

    public ItemModel getItem(int itemId)
    {
        return _itemService.getItem(itemId);
    }

    public void addItemToCart(ShoppingCartModel shoppingCart,ItemModel itemModel)
    {

        shoppingCart.addItem(itemModel);

        //set a (hopefully) unique number for each item
        itemModel.setShoppingCartItemId(Utilities.getRandomNumber());

        updateTotals(shoppingCart);
    }

    public void deleteItemFromCart(ShoppingCartModel shoppingCart,ItemModel itemModel)
    {
        shoppingCart.deleteItem(itemModel);
        updateTotals(shoppingCart);
    }

    public boolean applyDiscount(ShoppingCartModel shoppingCart, DiscountModel discountModel)
    {
        Enums.DiscountType discountType = discountModel.getDiscountType();
        boolean isDiscountInPercent = discountModel.isDiscountInPercent();
        double discountAmountValue = discountModel.getDiscountAmount();
        double amountToDiscountOffOrder = 0.0;
        boolean orderEligibleForDiscount = false;

        switch  (discountType){
            case OFFITEM:
                ItemModel item = shoppingCart.getDiscountItem(discountModel.getDiscountItemId());
                if(item != null)
                {
                  amountToDiscountOffOrder = isDiscountInPercent? item.getPrice() * discountAmountValue : item.getPrice() - discountAmountValue;
                }
                break;
            case OFFORDER:
                amountToDiscountOffOrder = isDiscountInPercent? Global.CURRENT_ORDER.getOrderTotal() * discountAmountValue : Global.CURRENT_ORDER.getOrderTotal() - discountAmountValue;
                orderEligibleForDiscount = true;
                break;
            case FREESHIPPING:
                amountToDiscountOffOrder = Global.CURRENT_ORDER.getShippingFee();
                orderEligibleForDiscount = true;
                break;
        }
        if(orderEligibleForDiscount) {
            Global.CURRENT_ORDER.setDiscount(amountToDiscountOffOrder);
            Global.CURRENT_ORDER.updateAllPriceTotals();
        }
        return orderEligibleForDiscount;
    }

    public void updateTotals(ShoppingCartModel shoppingCart)
    {
        //update all the prices on the order
        Global.CURRENT_ORDER.updateAllPriceTotals();
    }
}
