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

}
