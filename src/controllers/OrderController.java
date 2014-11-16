package controllers;

import businessLogic.OrderManager;
import global.Global;
import models.OrderModel;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderController {
    private static OrderManager _orderManager = new OrderManager();

    public static OrderModel createOrder() throws ClassNotFoundException {
        OrderModel orderModel = _orderManager.createOrder(0.00,0.00,0.00,Global.currentAccount.getUserId(),0.00,0,0.00);
        return  orderModel;
    }

    public static int submitOrder()
    {
        return _orderManager.submitOrder();
    }

    public static void updateOrder() {

    }

    public static void addItemToOrder()
    {
//        if(Global.currentOrder == null)
//        {
//            createOrder();
//        }
    }

    public static int[] getOrderIds(int userId)
    {
        return _orderManager.getOrderIds(userId);
    }

}
