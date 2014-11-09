package controllers;

import businessLogic.OrderManager;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderController {
    private static OrderManager _orderManager = new OrderManager();

    public static int submitOrder()
    {
        return _orderManager.submitOrder();
    }

}
