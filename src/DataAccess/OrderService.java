package DataAccess;

import businessLogic.OrderManager;
import models.DiscountModel;
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

    public void addItemToOrder(int orderId,int itemId, int quantity)
    {
                 int shoppingCartItemId = _orderRepository.getMaxShoppingCartItemIdOnOrder(orderId);
                if(shoppingCartItemId > -1)
                {
                    //increment by one
                    shoppingCartItemId++;
                    _orderRepository.addItemToOrder(orderId,itemId, shoppingCartItemId, quantity);
                }
                else
                {
                    //this is the first item on the order
                    _orderRepository.addItemToOrder(orderId,itemId, 1, quantity);
                }

    }

    public void updateOrder(OrderModel order)
    {
        _orderRepository.updateOrder(order);
    }

    public ArrayList<ItemModel> getItemsOnOrder(int orderId)
    {
        return _orderRepository.getItemsOnOrder(orderId);
    }

    public void deleteItemOnOrder(int orderId,int itemId,int shoppingCartItemId)
    {
        _orderRepository.deleteItemOnOrder(orderId, itemId, shoppingCartItemId);
    }

    public void editItemOnOrder(int orderId,int itemId,int shoppingCartItemId, int quantity)
    {
        _orderRepository.editItemOnOrder(orderId, itemId, shoppingCartItemId, quantity);
    }

    public ArrayList<Integer> getOrderIdsByUserId(int userId)
    {
        return _orderRepository.getOrderIdsByUserId(userId);
    }
}
