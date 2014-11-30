package controllers;

import businessLogic.OrderManager;
import global.Global;
import models.ItemModel;
import models.OrderModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderController {
    private static OrderManager _orderManager = new OrderManager();

    public static OrderModel getOrder(int orderId)
    {
        return _orderManager.getOrder(orderId);
    }

    public static OrderModel createOrder() throws ClassNotFoundException {
//        if(Global.CURRENT_ACCOUNT == null)
//        {
//            //todo remove this code
//            Global.CURRENT_ACCOUNT = AccountController.getAccountWithLogin("BholaRules","ImpossibleExams");
//        }
        if(Global.CURRENT_ACCOUNT != null)
        {
            OrderModel orderModel = _orderManager.createOrder(0.00,0.00,0.00,Global.CURRENT_ACCOUNT.getUserId(),0.00,0,Global.SHIPPING_FEE);
            return  orderModel;
        }
        System.out.println("User is not logged in, cannot create order");
        return null;
    }

    public static void submitOrder(OrderModel order, String firstName, String lastName, String address, String city, String state, String zipCode, String country, String phoneNumber, String email,
    String creditCardType, String cardHoldersName, String creditCardNumber, String expirationDate, String cvs)
    {
         _orderManager.submitOrder(order, firstName, lastName, address, city, state,zipCode,country,phoneNumber,email,creditCardType,cardHoldersName,creditCardNumber,expirationDate,cvs);
    }

    public static void updateOrder() {
              _orderManager.updateOrder();
    }

    public static Boolean addItemToOrder(int itemId, int quantity) throws ClassNotFoundException {
        if(Global.CURRENT_ORDER == null)
        {
            Global.CURRENT_ORDER = createOrder();
        }
        return _orderManager.addItemToOrder(Global.CURRENT_ORDER.getOrderId(),itemId, quantity);
    }

    public static void deleteItemFromOrder(int itemId, int shoppingCartItemId) throws ClassNotFoundException {
        _orderManager.deleteItemFromOrder(Global.CURRENT_ORDER.getOrderId(),itemId, shoppingCartItemId);
    }

    public static boolean editItemOnOrder(int itemId, int shoppingCartItemId, int quantity) throws ClassNotFoundException {
      return _orderManager.editItemOnOrder(Global.CURRENT_ORDER.getOrderId(),itemId, shoppingCartItemId, quantity);
    }

    public static ArrayList<ItemModel> getItemsOnOrder(int orderId)
    {
        return _orderManager.getItemsOnOrder(orderId);
    }

    public static int[] getOrderIds(int userId)
    {
        return _orderManager.getOrderIds(userId);
    }

    public static ArrayList<Integer> getOrderIdsByUserId(int userId)
    {
        return _orderManager.getOrderIdsByUserId(userId);
    }

    public static String applyDiscountToOrder(String discountCode)
    {
        if(discountCode.length() > 0)
        {
            return _orderManager.applyDiscountToOrder(discountCode);
        }
        else
        {
            //the user didn't enter a discountCode
            return "Please enter a discount code.";
        }
    }


}
