package DataAccess;

import models.DiscountModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class DiscountRepository extends BaseRepository {

    public DiscountModel getDiscountModel(String promoCode)
    {
        if(true)
        {
         //todo get Discount from database, using the promoCode
         DiscountModel discountModel = new DiscountModel();
         return discountModel;
        }
        else
        {
            return null;
        }
    }
}
