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
        if(Global.CURRENT_ACCOUNT == null)
        {
            //todo remove this code
            Global.CURRENT_ACCOUNT = AccountController.getAccountWithLogin("BholaRules","ImpossibleExams");
        }
        OrderModel orderModel = _orderManager.createOrder(0.00,0.00,0.00,Global.CURRENT_ACCOUNT.getUserId(),0.00,0,0.00);
        return  orderModel;
    }

    public static void submitOrder(OrderModel order)
    {
         _orderManager.submitOrder(order);
    }

    public static void updateOrder(OrderModel order) {
              _orderManager.updateOrder(order);
    }

    public static void addItemToOrder(int itemId) throws ClassNotFoundException {
        if(Global.CURRENT_ORDER == null)
        {
            Global.CURRENT_ORDER = createOrder();
        }
        _orderManager.addItemToOrder(Global.CURRENT_ORDER.getOrderId(),itemId);
    }

    public static ArrayList<ItemModel> getItemsOnOrder(int orderId)
    {
        return _orderManager.getItemsOnOrder(orderId);
    }

    public static int[] getOrderIds(int userId)
    {
        return _orderManager.getOrderIds(userId);
    }

}
