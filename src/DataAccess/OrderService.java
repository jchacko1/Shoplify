package DataAccess;

import businessLogic.OrderManager;
import models.ItemModel;
import models.OrderModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderService {
    DataAccess.OrderRepository _orderRepository;

    public OrderService()
    {
        _orderRepository = new OrderRepository();
    }

    public OrderModel getOrder(int orderId)
    {
        return _orderRepository.getOrder(orderId);
    }

    public void submitOrder(OrderModel order)
    {
                _orderRepository.submitOrder(order);
    }

    public int[] getOrderIds(int userId)
    {
        return _orderRepository.getOrderIds(userId);
    }

    public OrderModel createOrder(double orderTotal, double subTotal, double tax, int userId, double discountAmount, int isSubscriptionOrder, double shippingFee) throws ClassNotFoundException {
        return _orderRepository.createOrder(orderTotal,subTotal,tax,userId,discountAmount,isSubscriptionOrder,shippingFee);
    }

    public void addItemToOrder(int orderId,int itemId)
    {
        _orderRepository.addItemToOrder(orderId,itemId);
    }

    public void updateOrder(OrderModel order)
    {
        _orderRepository.updateOrder(order);
    }

    public ArrayList<ItemModel> getItemsOnOrder(int orderId)
    {
        return _orderRepository.getItemsOnOrder(orderId);
    }
}
