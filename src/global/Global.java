package global;

import models.AccountModel;
import models.ItemModel;
import models.OrderModel;
import models.UserModel;

import java.util.ArrayList;

/**
 * Created by jmarquez on 10/23/2014.
 */
public class Global {
    public static OrderModel CURRENT_ORDER;
    public static AccountModel CURRENT_ACCOUNT;
    public static double SHIPPING_FEE = 5.00;
    public static ArrayList<ItemModel> REMINDERITEMLIST;

}
