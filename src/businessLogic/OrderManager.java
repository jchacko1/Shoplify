package businessLogic;

import DataAccess.OrderService;
import global.Global;

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
}
