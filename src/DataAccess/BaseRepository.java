package DataAccess;

/**
 * Created by jmarquez on 11/9/2014.
 */
public class BaseRepository {
    private final String _classForName = "org.sqlite.JDBC";
    private final String _connectionString = "jdbc:sqlite:src/DataAccess/shoplify.db";
    //This is for Jar output
    //private final String _connectionString = "jdbc:sqlite:shoplify.db";

    public String getClassForName()
    {
        return _classForName;
    }

    public String getConnectionString()
    {
        return _connectionString;
    }

}
