package DataAccess;

/**
 * Created by jmarquez on 10/18/2014.
 */
import models.AccountModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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

            //if(size == 1)
            //{
                //todo move this code up so we can use this for validation
                while ( rs.next()) {
                    if(rowCount == 1)
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
}
