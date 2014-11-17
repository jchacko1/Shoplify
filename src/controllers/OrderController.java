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

    public static OrderModel createOrder() throws ClassNotFoundException {
        OrderModel orderModel = _orderManager.createOrder(0.00,0.00,0.00,Global.currentAccount.getUserId(),0.00,0,0.00);
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
        if(Global.currentOrder == null)
        {
            Global.currentOrder = createOrder();
        }
        _orderManager.addItemToOrder(Global.currentOrder.getOrderId(),itemId);
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
