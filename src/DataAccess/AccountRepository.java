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

    /**
     * Test Account DB syndication
     * @throws ClassNotFoundException
     */
    public void testSql() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from person");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

    public AccountModel createAccount(String login, String password)
    {
              //todo create Account in database
              return new AccountModel(-1,-1,"");
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
               return new AccountModel(accountId,userModelId,userName );
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
        String userName = "";
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
                userName = rs.getString("UserName");
                System.out.println( "UserName = " + userName );
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
            return new AccountModel(accountId,userModelId,userName );
        }
        return null;
    }


}
