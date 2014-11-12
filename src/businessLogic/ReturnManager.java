package businessLogic;

import DataAccess.OrderService;
import global.Global;
import DataAccess.ItemService;
import DataAccess.ReturnService;
import models.ReturnModel;
import models.AccountModel;

import java.io.File;

/**
 * Created by KellyAnn on 11/9/14.
 */
public class ReturnManager {
    private ReturnService _returnService = new ReturnService();

    public void updateReturnInfo(ReturnModel returnModel) {
        //TODO:update Return info
    }

    public void getReturnForm(File file){
        //TODO:need import return form from local
    }

    /*public ReturnModel creatReturn(){

    }*/


}
