package telebot;

import java.sql.*;

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:schedule.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM SCHEDULE;" );
      System.out.println("Расписание на пн, четный:");
      while ( rs.next() ) {
         
    	  
         String  time = rs.getString("TIME");
         String FIRSTWEEKMONDAY  = rs.getString("FIRSTWEEKMONDAY");
        
         
         System.out.println( time );
         System.out.println( FIRSTWEEKMONDAY );
         
         
         System.out.println();
      
      }
     
     rs = stmt.executeQuery( "SELECT * FROM SCHEDULE;" );
System.out.println("Расписание пн, нечетный:");
while ( rs.next() ) {
    
	  
    String  time = rs.getString("TIME");
    String SECONDWEEK  = rs.getString("SECONDWEEKMONDAY");
   
    
    System.out.println( time );
    System.out.println( SECONDWEEK );
    
    
    System.out.println();
 
 }
     
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
}