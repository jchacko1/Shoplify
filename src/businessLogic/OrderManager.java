package businessLogic;

import DataAccess.DiscountService;
import DataAccess.OrderService;
import controllers.ItemController;
import global.Global;
import models.DiscountModel;
import models.Enums;
import models.ItemModel;
import models.OrderModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderManager {
    private OrderService _orderService = new OrderService();
    private DiscountService _discountService = new DiscountService();

    public OrderModel getOrder(int orderId)
    {
        return _orderService.getOrder(orderId);
    }

        public void submitOrder(OrderModel order, String firstName, String lastName, String address, String city, String state, String zipCode, String country, String phoneNumber, String email,
                                String creditCardType, String cardHoldersName, String creditCardNumber, String expirationDate, String cvs)
        {
            order.setFirstNameOnOrder(firstName);
            order.setLastNameOnOrder(lastName);
            order.setAddress(address);
            order.setCity(city);
            order.setState(state);
            order.setZipCode(zipCode);
            order.setCountry(country);
            order.setPhoneNumber(phoneNumber);
            order.setEmail(email);
            order.setCreditCardType(creditCardType);
            order.setCardHoldersName(cardHoldersName);
            order.setCreditCardNumber(creditCardNumber);
            order.setExpirationDate(expirationDate);
            order.setCvs(cvs);
            _orderService.submitOrder(order);

            //remove the order from the Session so we can start a new order
            Global.CURRENT_ORDER = null;


        }

    public int[] getOrderIds(int userId)
    {
        return _orderService.getOrderIds(userId);
    }

    public OrderModel createOrder(double orderTotal, double subTotal, double tax, int userId, double discountAmount, int isSubscriptionOrder, double shippingFee) throws ClassNotFoundException {
        return _orderService.createOrder(orderTotal,subTotal,tax,userId,discountAmount,isSubscriptionOrder,shippingFee);
    }

    public boolean addItemToOrder(int orderId,int itemId, int quantity)
    {
        ItemModel itemToAdd = ItemController.getItem(itemId);

        //insert into the OrderItems table
        _orderService.addItemToOrder(orderId,itemId,quantity);

        //update the current order in the Global session and in the database
        Global.CURRENT_ORDER._shoppingCart.addItem(itemToAdd);
        System.out.println("Item added to cart, need to update prices");
        Global.CURRENT_ORDER.updateAllPriceTotals();
        System.out.println("Price Totals updated");
        updateOrder(Global.CURRENT_ORDER);
        System.out.println("Order updated");
        return true;
    }

    public  void deleteItemOnOrder(int orderId, int itemId, int shoppingCartItemId) throws ClassNotFoundException {
        _orderService.deleteItemOnOrder(orderId, itemId, shoppingCartItemId);
        Global.CURRENT_ORDER.updateAllPriceTotals();
        updateOrder(Global.CURRENT_ORDER);
    }

    public boolean editItemOnOrder(int orderId, int itemId, int shoppingCartItemId, int quantity) throws ClassNotFoundException {
       _orderService.editItemOnOrder(orderId,itemId, shoppingCartItemId, quantity);

        Global.CURRENT_ORDER.updateAllPriceTotals();
        updateOrder(Global.CURRENT_ORDER);
        return true;
    }

    public  ArrayList<ItemModel> getItemsOnOrder(int orderId)
    {
        return _orderService.getItemsOnOrder(orderId);
    }

    public void updateOrder(OrderModel order)
    {
        _orderService.updateOrder(order);
    }

    public ArrayList<Integer> getOrderIdsByUserId(int userId)
    {
        return _orderService.getOrderIdsByUserId(userId);
    }

    public String applyDiscountToOrder(String discountCode)
    {
        DiscountModel discountModel = _discountService.getDiscount(discountCode);
        double discountAmount = 0.00;
        Global.CURRENT_ORDER.setDiscountCode(discountCode);

        if(discountModel.getDiscountType() == Enums.DiscountType.OFFORDER)
        {
            discountAmount = discountModel.getIsDiscountInPercent() ? Global.CURRENT_ORDER.getSubTotal() * discountModel.getDiscountAmount() * -1 : discountModel.getDiscountAmount();
            Global.CURRENT_ORDER.setDiscount(discountAmount);
            Global.CURRENT_ORDER.updateAllPriceTotals();
            updateOrder(Global.CURRENT_ORDER);
            return "Discount applied!";
        }
        else if(discountModel.getDiscountType() == Enums.DiscountType.OFFITEM)
        {
            ArrayList<ItemModel> items = Global.CURRENT_ORDER._shoppingCart.getItems();
            boolean itemExistsOnOrder = false;
            for(ItemModel item : items)
            {
                 if(item.getItemID() == discountModel.getDiscountItemId())
                 {
                     itemExistsOnOrder = true;
                 }
            }

            if(itemExistsOnOrder)
            {
                discountAmount = discountModel.getIsDiscountInPercent() ? Global.CURRENT_ORDER.getSubTotal() * discountModel.getDiscountAmount() * -1 : discountModel.getDiscountAmount();
                Global.CURRENT_ORDER.setDiscount(discountAmount);
                Global.CURRENT_ORDER.updateAllPriceTotals();
                updateOrder(Global.CURRENT_ORDER);
                return "Discount applied!";
            }
            else
            {
                return "Discount item does not exist on order!";
            }
        }
        else if(discountModel.getDiscountType() == Enums.DiscountType.FREESHIPPING)
        {
            return "Free shipping applied!";
        }

        return "Discount could not be applied!";
    }
}
