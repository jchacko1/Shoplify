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

    public static int[] getOrderIds(int userId)
    {
        return _orderManager.getOrderIds(userId);
    }

    public static void testSql() throws ClassNotFoundException {
        _orderManager.testSql();
    }
}
