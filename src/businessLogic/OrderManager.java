package businessLogic;

import DataAccess.OrderService;
import controllers.ItemController;
import global.Global;
import models.ItemModel;
import models.OrderModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderManager {
    private OrderService _orderService = new OrderService();

        public void submitOrder(OrderModel order)
        {
            //remove the order from the Session so we can start a new order
            Global.currentOrder = null;

            //todo dont need to do anything to the database unless we add a column that shows the OrderStatus (completed, pending, etc)
              _orderService.submitOrder(order);
        }

    public int[] getOrderIds(int userId)
    {
        return _orderService.getOrderIds(userId);
    }

    public OrderModel createOrder(double orderTotal, double subTotal, double tax, int userId, double discountAmount, int isSubscriptionOrder, double shippingFee) throws ClassNotFoundException {
        return _orderService.createOrder(orderTotal,subTotal,tax,userId,discountAmount,isSubscriptionOrder,shippingFee);
    }

    public void addItemToOrder(int orderId,int itemId)
    {
        //insert into the OrderItems table
        _orderService.addItemToOrder(orderId,itemId);

        //update the current order in the Global session and in the database
        ItemModel itemToAdd = ItemController.getItem(itemId);
        Global.currentOrder._shoppingCart.addItem(itemToAdd);
        Global.currentOrder.updateAllPriceTotals();
        updateOrder(Global.currentOrder);
    }

    public  ArrayList<ItemModel> getItemsOnOrder(int orderId)
    {
        return _orderService.getItemsOnOrder(orderId);
    }

    public void updateOrder(OrderModel order)
    {
        _orderService.updateOrder(order);
    }
}
