package DataAccess;

import models.AccountModel;
import models.Enums;
import models.UserModel;
import models.UserModelDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserRepository extends BaseRepository {

    public UserModelDto getUser(int userId)
    {
        {
            Connection c = null;
            Statement stmt = null;
            String createDate = "";
            String firstName = "";
            String lastName = "";
            int isAdmin = -1;
            int userTypeId = -1;
            int accountId = -1;
            String address = "";
            String phoneNumber = "";
            String dateOfBirth = "";
            String gender = "";
            String email = "";
            int shoppingListId = -1;
            int subscriptionId = -1;
            int canEditItems = -1;
            int canEditUsers = -1;
            int canRefundOrders = -1;
            int securityQuestionId = -1;
            String securityAnswer = "";
            try {
                System.out.println("begin User table try block");
                Class.forName(getClassForName());
                c = DriverManager.getConnection(getConnectionString());
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM User WHERE UserId = " + userId + ";" );
                while ( rs.next() ) {
                    firstName = rs.getString("FirstName");
                    lastName = rs.getString("LastName");
                    isAdmin = rs.getInt("IsAdmin");
                    userTypeId = rs.getInt("UserType");
                    accountId = rs.getInt("AccountID");
                    address = rs.getString("Address");
                    phoneNumber = rs.getString("PhoneNumber");
                    dateOfBirth = rs.getString("DateOfBirth");
                    gender = rs.getString("Gender");
                    email = rs.getString("Email");
                    shoppingListId = rs.getInt("ShoppingListId");
                    subscriptionId = rs.getInt("SubscriptionId");
                    canEditItems = rs.getInt("CanEditItems");
                    canEditUsers = rs.getInt("CanEditUsers");
                    canRefundOrders = rs.getInt("CanRefundOrders");
                    securityQuestionId = rs.getInt("SecurityQuestionId");
                    securityAnswer = rs.getString("SecurityAnswer");
                    System.out.println( "FirstName = " + firstName );
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            if(!firstName.isEmpty())
            {
                Enums.UserType userType = Enums.UserType.values()[userTypeId];
                return new UserModelDto(userId,createDate,firstName,lastName,isAdmin == 1,userType,accountId,address,phoneNumber,dateOfBirth,gender,email,subscriptionId,
                        canEditItems == 1, canEditUsers == 1, canRefundOrders == 1);
            }
            return null;
        }
    }

    public UserModel createUser(String firstName, String lastName, String userType)
    {
        //TODO insert the UserModel into the database
        UserModel userModel = new UserModel();
         return userModel;
    }

    public int createNewSubscription(int userId)
    {
        int subscriptionId = 1; //todo this needs to be a primary key from the Subscription table
        return subscriptionId;
    }
}
