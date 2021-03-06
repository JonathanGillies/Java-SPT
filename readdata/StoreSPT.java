package readdata;
import java.sql.*;
import java.util.*;

public class StoreSPT{
  
  String url = "jdbc:mysql://localhost:3306/buoy_data";
  String username = "root";
  String password = "";
  Connection connection = null; 
  Statement stmt=null;
 
  public StoreSPT(){
    try {
      System.out.println("Loading JDBC driver...");
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("JDBC driver successfully loaded!");
      connection = DriverManager.getConnection(url, username, password);
      //query = "insert into spt values("")";
  
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }
  
  public void writeRecord(DataSPT dataSPT){
    try {
      stmt = connection.createStatement();
      System.out.println(dataSPT.datetime);
      String sql = "INSERT INTO spt (date_time, Hs, Tz, Battery)" +
        "VALUES (" + dataSPT.datetime + ", "  + dataSPT.hs + ", " + dataSPT.tz + ", " + dataSPT.battery + ")";
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }

}
