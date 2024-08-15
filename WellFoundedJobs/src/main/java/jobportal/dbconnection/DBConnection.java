package jobportal.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
private static final String dburl="jdbc:oracle:thin:@localhost:1521:xe";
private static final String uName="C##MYJDBC";
private static final String pWd="ORACLE";

static {
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
}catch(ClassNotFoundException e) {
	e.printStackTrace();
}
}
public static Connection getConnection() throws SQLException {
	return DriverManager.getConnection(dburl,uName,pWd);
}

}
