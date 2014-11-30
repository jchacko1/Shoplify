package DataAccess;

import models.DiscountModel;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class DiscountService {
    DataAccess.DiscountRepository _discountRepository;

    public DiscountService()
    {
        _discountRepository = new DiscountRepository();
    }

    public DiscountModel getDiscount(String discountCode)
    {
        return _discountRepository.getDiscount(discountCode);
    }
}
