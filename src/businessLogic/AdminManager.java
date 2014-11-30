package businessLogic;

import DataAccess.AdminService;
import DataAccess.UserService;
import models.AdminModel;

/**
 * Created by KellyAnn on 11/30/14.
 */
public class AdminManager {

    private AdminService _adminService = new AdminService();

    public AdminModel getAdmin(int adminId){
        return _adminService.getAdmin(adminId);
    }

}
