package DataAccess;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserService {

    DataAccess.UserRepository _userRepository;

    public UserService()
    {
        _userRepository = new UserRepository();
    }
}
