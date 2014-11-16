package DataAccess;

import businessLogic.OrderManager;
import models.OrderModel;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderService {
    DataAccess.OrderRepository _orderRepository;

    public OrderService()
    {
        _orderRepository = new OrderRepository();
    }

    public int submitOrder(OrderModel order)
    {
                 return _orderRepository.submitOrder(order);
    }

    public int[] getOrderIds(int userId)
    {
        return _orderRepository.getOrderIds(userId);
    }

    public OrderModel createOrder(double orderTotal, double subTotal, double tax, int userId, double discountAmount, int isSubscriptionOrder, double shippingFee) throws ClassNotFoundException {
        return _orderRepository.createOrder(orderTotal,subTotal,tax,userId,discountAmount,isSubscriptionOrder,shippingFee);
    }

}
