package businessLogic;

import DataAccess.AdminService;
import DataAccess.ItemService;
import DataAccess.UserService;
import models.AdminModel;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class AdminManager {

    private AdminService _adminService = new AdminService();
    private ItemService _itemService = new ItemService();

    public AdminModel getAdmin(int adminId){
        return _adminService.getAdmin(adminId);
    }

    public void adjustPriceOnItem(int itemId, double price)
    {
        _itemService.adjustPriceOnItem(itemId, price);
    }

    public void deleteItem(int itemId)
    {
        _itemService.deleteItem(itemId);
    }

    public void addItem(String itemName, double price, int quantity, String description, int categoryId, int shoppingCartItemId)
    {
        _itemService.addItem(itemName, price, quantity, description,categoryId,shoppingCartItemId);
    }
}
