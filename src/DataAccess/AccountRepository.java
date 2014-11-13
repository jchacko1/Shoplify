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

    public AccountModel createAccount(String login, String password)
    {
              //todo create Account in database
              return new AccountModel(-1,-1,"","");
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
               System.out.println("begin Account table try block");
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
            System.out.println("begin Account table try block");
            Class.forName(getClassForName());
            c = DriverManager.getConnection(getConnectionString());
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Account WHERE UserName = " + login + " and Password = " + password + ";" );
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


}
