package DataAccess;

import controllers.OrderController;
import models.ReturnModel;

/**
 * Created by KellyAnn on 11/9/14.
 */
//return id, order id
public class ReturnService {

    //http://stackoverflow.com/questions/3801438/store-and-retrieve-word-documents-with-mysql

    ReturnRepository _returnRepository;
    public ReturnService(){
        _returnRepository = new ReturnRepository();
    }

    public void submitReturn(ReturnModel returnModel){
       // _returnRepository.submitReturn;
    }

    public int[] getReturnId(int returnId){
        return _returnRepository.getReturnId(returnId);
    }

    public ReturnModel createReturn( int orderId, double orderTotal, int userId, int isSubscriptionOrder) throws ClassNotFoundException{
        return _returnRepository.createReturn(orderId, orderTotal, userId, isSubscriptionOrder);
    }


}
