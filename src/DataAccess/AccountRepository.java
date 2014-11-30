package DataAccess;

/**
 * Created by jmarquez on 10/18/2014.
 */
import models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AccountRepository extends BaseRepository {

    public AccountModel createAccount(String userName, String password, int userModelId)
    {
        Connection c = null;
        Statement stmt = null;
        int accountId = -1;
        try {
            System.out.println("begin create Account table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String query = "Insert into Account(UserModelId, UserName, Password)values(" + '"' + userModelId + '"' + "," + '"'  + userName + '"' + "," + '"' + password + '"' + ");";
            accountId = stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid()");
            while ( rs.next() ) {
                accountId = rs.getInt(1);
            }
            System.out.println("AccountId is:" + accountId);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if(accountId > -1)
        {
            return new AccountModel(accountId,userModelId,userName,password );
        }
        return null;
    }

    public void updateUserIdOnAccount(int accountId, int userId)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin create Account table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            //String query = "select max(accountid) from account";
            //accountId = stmt.executeUpdate(query);
            System.out.println("Last AccountId is:" + accountId);
            String query = "Update Account set UserModelId = " + userId + " where AccountId = " + accountId + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public void updateAccount(AccountModel accountModel)
    {

    }

   public AccountModel getAccount(int accountId)
   {
       {
           Connection c = null;
           Statement stmt = null;
           int userModelId = -1;
           String userName = "";
           String password = "";
           try {
               System.out.println("begin get Account by id table try block");
               Class.forName(getClassForName());
               c = DriverManager.getConnection(getConnectionString());
               c.setAutoCommit(false);
               System.out.println("Opened database successfully");
               stmt = c.createStatement();
               ResultSet rs = stmt.executeQuery( "SELECT * FROM Account WHERE AccountId = " + accountId + ";" );
               while ( rs.next() ) {
                   userModelId = rs.getInt("UserModelId");
                   userName = rs.getString("UserName");
                   password = rs.getString("Password");
                   System.out.println( "UserName = " + userName );
               }
               rs.close();
               stmt.close();
               c.close();
           } catch ( Exception e ) {
               System.err.println( e.getClass().getName() + ": " + e.getMessage() );
               System.exit(0);
           }
           if(!userName.isEmpty())
           {
               return new AccountModel(accountId,userModelId,userName,password );
           }
           return null;
       }
   }

    public AccountModel getAccount(String login, String password)
    {
        Connection c = null;
        Statement stmt = null;
        int accountId = -1;
        int userModelId = -1;
        try {
            System.out.println("begin get Account by login and password table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            String query =    "SELECT * FROM Account WHERE UserName = "+ '"' + login + '"' + " and Password = " + '"' + password + '"' + ";";
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Account WHERE UserName = " + '"' + login + '"' + " and Password = " + '"' + password + '"' + ";" );
            while ( rs.next() ) {
                accountId = rs.getInt("AccountId");
                userModelId = rs.getInt("UserModelId");
                System.out.println( "AccountId = " + accountId );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if(accountId > -1)
        {
            return new AccountModel(accountId,userModelId,login, password );
        }
        return null;
    }

    public AccountModel getAccountFromUserName(String userName)
    {
        Connection c = null;
        Statement stmt = null;
        int accountId = -1;
        int userModelId = -1;
        String password = "";
        try {
            System.out.println("begin get Account by UserName try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            String query =    "SELECT * FROM Account WHERE UserName = "+ '"' + userName + '"' + ";";
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Account WHERE UserName = " + '"' + userName + '"' +  ";" );
            int rowCount = rs.getRow();
                //todo move this code up so we can use this for validation
                while ( rs.next()) {
                    if(rowCount == 0)
                    {
                        accountId = rs.getInt("AccountId");
                        userModelId = rs.getInt("UserModelId");
                        password = rs.getString("Password");
                        System.out.println( "Found one Account by UserName, AccountId = " + accountId );
                        rowCount++;
                    }
                    else
                    {
                        System.out.println( "We have more than one Account with the same user name! Returning null" );
                        accountId = -1;
                    }
              }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if(accountId > -1)
        {
            return new AccountModel(accountId,userModelId,userName, password );
        }
        return null;
    }

    public boolean createSubscription(String shipDate, boolean enabled, SubscriptionUserModel subscriptionUserModel)
    {
        Connection c = null;
        Statement stmt = null;
        int userId = subscriptionUserModel.getUserId();
        int isEnabled = enabled? 1 : 0;
        int subscriptionId = -1;
        try {
            System.out.println("begin create Subscription table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String query = "Insert into Subscription(UserId, ShipDate, Enabled)values(" + '"' + userId + '"' + "," + '"'  + shipDate + '"' + "," + '"' + isEnabled + '"' + ");";
            //subscriptionId = stmt.executeUpdate(query);
            ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid()");
            while ( rs.next() ) {
                subscriptionId = rs.getInt(1);
            }
            System.out.println("AccountId is:" + subscriptionId);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if(subscriptionId > -1)
        {
            subscriptionUserModel.setSubscriptionId(subscriptionId);
            return true;
        }
        return false;
    }

    public boolean updateSubscription(String shipDate, boolean enabled, SubscriptionUserModel subscriptionUserModel)
    {
        int isEnabled = enabled? 1 : 0;
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
            String query = "Update Subscription set ShipDate = " + "''" + shipDate + "'" + ", Enabled=" + isEnabled + " where SubscriptionId = " + subscriptionUserModel.getSubscriptionId() + ";";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return true;
    }

    public void insertSavedPaymentInformationModel(int userId, String creditCardType, String cardHoldersName, String creditCardNumber, String expirationDate, String cvs)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            System.out.println("begin insert SavedPaymentInformation table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(true);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String query = "Insert into SavedPaymentInformation(UserId, CreditCardType,CardholdersName,CreditCardNumber,ExpirationDate,Cvs)values(" + '"' + userId + '"' + "," + '"'  + creditCardType + '"' + "," + '"' + cardHoldersName + '"' + creditCardNumber + '"' + expirationDate + '"' + cvs + '"' + ");";
            stmt.executeUpdate(query);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public ArrayList<SavedPaymentInformationModel> getSavedPayments(int userId)
    {
        ArrayList<SavedPaymentInformationModel> savedPayments = new ArrayList<SavedPaymentInformationModel>();
        String creditCardType;
        String cardHoldersName;
        String creditCardNumber;
        String expirationDate;
        String cvs;
        Connection c = null;
        Statement stmt = null;

        try {
            System.out.println("begin get SavedPaymentInformations for User try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM SavedPaymentInformation WHERE UserId = " + "''" + userId + "'" + ";");
            while ( rs.next() ) {
                creditCardType = rs.getString("CreditCardType");
                cardHoldersName = rs.getString("CardholdersName");
                creditCardNumber = rs.getString("CreditCardNumber");
                expirationDate = rs.getString("ExpirationDate");
                cvs = rs.getString("Cvs");
                SavedPaymentInformationModel savedPaymentInformationModel = new SavedPaymentInformationModel(creditCardType,cardHoldersName,creditCardNumber,expirationDate,cvs);
                savedPayments.add(savedPaymentInformationModel);}
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return savedPayments;
    }
}
