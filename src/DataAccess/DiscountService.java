package DataAccess;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class DiscountService {
    DataAccess.DiscountRepository _discountRepository;

    public DiscountService()
    {
        _discountRepository = new DiscountRepository();
    }
}
