package jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JdbcTest {
	
	private static final Logger logger = Logger.getLogger(JdbcTest.class);

    private Connection con;                                                                                                       

    @Before
    public void setup() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/netflix_subscription?allowPublicKeyRetrieval=true&useSSL=false", "user1", "pass");

        Statement stmt = con.createStatement();

        String tableSql = "create table if not exists currency_code(currency_code CHAR NOT NULL, currency_code_alpha CHAR NOT NULL, conversion_value decimal(6,4), PRIMARY KEY(currency_code));";
        stmt.execute(tableSql);

    }
    
    @After
    public void closeConnection() throws SQLException {

//        Statement updatableStmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//        ResultSet updatableResultSet = updatableStmt.executeQuery("SELECT * FROM employees");
//
//        while (updatableResultSet.next()) {
//            updatableResultSet.deleteRow();
//        }

        con.close();
    }

	
	

}
