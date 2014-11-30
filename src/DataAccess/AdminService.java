package DataAccess;

import models.AdminModel;
import models.UserModelDto;

/**
 * Created by KellyAnn on 11/10/14.
 */
public class AdminService {


    public boolean add(AdminModel model){
        //TODO: check the admin model
        return false;
    }

    public AdminModel getLoginModel(){
        return null;
    }

    public void updateInfo(AdminModel model) {

    }

    public AdminModel getAdmin(int adminId) {
        //TODO: getAdmin from UserRepo? Since UserModelDto already has boolean type check isAdmin or not?
        return null;
    }



    public AdminModel getModel(String userId){
        return null;
    }

    public AdminModel getModel(String loginName, String password){
        return null;
    }

}
