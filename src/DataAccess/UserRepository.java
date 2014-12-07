package DataAccess;

import models.*;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class UserRepository extends BaseRepository {

    /**
     * Get user info from userId
     * @param userId
     * @return
     */
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
                    accountId = rs.getInt("AccountId");
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
                        canEditItems == 1, canEditUsers == 1, canRefundOrders == 1,securityQuestionId,securityAnswer);
            }
            return null;
        }
    }

    public boolean isUserDisabled(int userId)
    {

            Connection c = null;
            Statement stmt = null;
            int disable = 0;
            try {
                System.out.println("begin User table try block");
                Class.forName(getClassForName());
                c = DriverManager.getConnection(getConnectionString());
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM User WHERE UserId = " + userId + ";" );
                while ( rs.next() ) {
                    disable = rs.getInt("Disable");
                }
                rs.close();
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
        return disable == 1;
    }

    public RegisteredUserModel createRegisteredUser(String firstName, String lastName, String dateOfBirth,String gender,int accountId, String address,String email, String phoneNumber, int securityQuestionId, String securityAnswer)
    {
        {
            Connection c = null;
            Statement stmt = null;
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Calendar calobj = Calendar.getInstance();
            int userId = -1;
            try {
                System.out.println("begin create Registered User table try block");
                Class.forName(getClassForName());
                c = DriverManager.getConnection(getConnectionString());
                c.setAutoCommit(true);
                String date =   String.valueOf(df.format(calobj.getTime()));
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                 stmt.executeUpdate("Insert into User(CreateDate,FirstName,LastName,IsAdmin,UserType,AccountId,Address,PhoneNumber,DateOfBirth,Gender,Email,ShoppingListId,SubscriptionId,CanEditItems,CanEditUsers,CanRefundOrders,SecurityQuestionId,SecurityAnswer)"
                        + "values(" + "'" + date + "'" + "," + '"' + firstName + '"' + "," + '"' + lastName + '"' + "," + 0 + "," + 2 + "," + accountId + "," + '"' + address + '"' + "," + '"' + phoneNumber + '"' + "," + '"' + dateOfBirth + '"' + "," + '"' + gender + '"' + "," + '"' + email + '"' + "," + -1 + "," + -1 + "," + 0 + "," + 0 + "," + 0 + "," + securityQuestionId + "," + '"' + securityAnswer + '"' + ");");
                ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid()");
                while ( rs.next() ) {
                    userId = rs.getInt(1);
                }
                System.out.println( "userId = " + userId );
                stmt.close();
                c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            if(userId > -1)
            {
             System.out.println("Log: Creating RegisteredUserModel for Return");
             return new RegisteredUserModel(userId, df.format(calobj.getTime()),firstName,lastName,false,Enums.UserType.values()[2],accountId,address,phoneNumber,dateOfBirth,gender,email,securityQuestionId,securityAnswer);
            }
            return null;
        }
    }

    public int createNewSubscription(int userId)
    {
        int subscriptionId = 1; //todo this needs to be a primary key from the Subscription table
        return subscriptionId;
    }

    public boolean updateRegisteredUser(RegisteredUserModel registeredUserModel)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin update Registered User table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            //String query = "select max(accountid) from account";
            //accountId = stmt.executeUpdate(query);
            //System.out.println("Last AccountId is:" + accountId);
            String query = "Update User set FirstName = " + "'" + registeredUserModel.getFirstName() + "'" + ",LastName = " + "'" + registeredUserModel.getLastName() + "'" + ", isAdmin = " + registeredUserModel.getIsAdmin() + ", UserType = " + registeredUserModel.getUserTypeId()
             + ", Address = "  + "'" + registeredUserModel.getAddress() + "'" + ", PhoneNumber = " + "'" + registeredUserModel.getPhoneNumber() + "'" +
            ", DateOfBirth = " + "'" + registeredUserModel.getDateOfBirth() + "'" + ", Gender = " + "'" + registeredUserModel.getGender() + "'" + ", Email = " + "'" + registeredUserModel.getEmail() + "'" +
            ", SecurityQuestionId = " + "'" + registeredUserModel.getSecurityQuestionId() + "'" + ",SecurityAnswer = " + "'" + registeredUserModel.getSecurityAnswer() + "'" +  " where UserId = " + registeredUserModel.getUserId() + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return true;
    }

    public boolean updateSubscriptionUser(SubscriptionUserModel subscriptionUserModel)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin update Subscription User table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            //String query = "select max(accountid) from account";
            //accountId = stmt.executeUpdate(query);
            //System.out.println("Last AccountId is:" + accountId);
            String query = "Update User set FirstName = " + "'" + subscriptionUserModel.getFirstName() + "'" + ",LastName = " + "'" + subscriptionUserModel.getLastName() + "'" + ", isAdmin = " + subscriptionUserModel.getIsAdmin() + ", UserType = " + subscriptionUserModel.getUserTypeId()
                    + ", Address = "  + "'" + subscriptionUserModel.getAddress() + "'" + ", PhoneNumber = " + "'" + subscriptionUserModel.getPhoneNumber() + "'" +
                    ", DateOfBirth = " + "'" + subscriptionUserModel.getDateOfBirth() + "'" + ", Gender = " + "'" + subscriptionUserModel.getGender() + "'" + ", Email = " + "'" + subscriptionUserModel.getEmail() + "'" +
                    ", SecurityQuestionId = " + "'" + subscriptionUserModel.getSecurityQuestionId() + "'" + ",SecurityAnswer = " + "'" + subscriptionUserModel.getSecurityAnswer() + "'" +
                   "SubscriptionId = " + subscriptionUserModel.getSubscriptionId() + " where UserId = " + subscriptionUserModel.getUserId() + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return true;
    }

}
