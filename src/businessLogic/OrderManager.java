package businessLogic;

import DataAccess.OrderService;
import global.Global;
import models.OrderModel;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderManager {
    private OrderService _orderService = new OrderService();

        public int submitOrder()
        {
               return _orderService.submitOrder(Global.currentOrder);
        }

    public int[] getOrderIds(int userId)
    {
        return _orderService.getOrderIds(userId);
    }

    public OrderModel createOrder(double orderTotal, double subTotal, double tax, int userId, double discountAmount, int isSubscriptionOrder, double shippingFee) throws ClassNotFoundException {
        return _orderService.createOrder(orderTotal,subTotal,tax,userId,discountAmount,isSubscriptionOrder,shippingFee);
    }
}
