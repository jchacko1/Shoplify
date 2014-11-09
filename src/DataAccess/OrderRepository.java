package DataAccess;

import models.OrderModel;

/**
 * Created by jmarquez on 11/5/2014.
 */
public class OrderRepository {

    public int submitOrder(OrderModel order)
    {
     //todo insert the Order record
     //todo insert records for each item ordered, into OrderItem. Associate the Items with a user
     //todo return the OrderId

        return 1;
    }

    public int[] getOrderIds(int userId)
    {
        //todo get an array of OrderIds
        return new int[]{1,2,3};
    }
}
