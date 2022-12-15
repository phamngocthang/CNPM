
package context;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
	/*
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";databaseName="+dbName;
        if(instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }   
    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class
    private final String serverName = "DESKTOP-CHR7MJP\\SQLEXPRESS";
    private final String dbName = "Wish";
    private final String portNumber = "1433";
    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "816570";
    */
	// mysql://b2878b09d91f51:4da99eb2@us-cdbr-east-06.cleardb.net/heroku_7ceacf08c297035?reconnect=true
	//private static String DB_URL = "jdbc:mysql://localhost:3306/shopshoes_test";
	/*
	private static String DB_URL = "jdbc:mysql://b344f457c2fba7:3e3fdf5f@us-cdbr-east-06.cleardb.net/heroku_a6e7885fa904cbb?reconnect=true";
    private static String USER_NAME = "b344f457c2fba7";
    private static String PASSWORD = "3e3fdf5f";
    */
    
	private static String DB_URL = "jdbc:mysql://localhost:3306/quanlydetai";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456789";
   
    public Connection getConnection() throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD); 
    }
    public static void main(String[] args) {
		DBContext db = new DBContext();
		try {
			System.out.println(db.getConnection());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}

 