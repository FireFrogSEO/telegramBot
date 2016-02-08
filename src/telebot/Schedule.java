package telebot;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.*;

public class Schedule {
	
	
	public static String takeSchedule() {
		
		Calendar C = new GregorianCalendar();
		
		int week = C.getWeekYear();
		int day = 7 - (8 - new GregorianCalendar().get(Calendar.DAY_OF_WEEK))%7;
		String sDay = "";
		String sNiceDay = "";
		if (day == 1) {
			sDay = "MONDAY";
			sNiceDay = "�����������";
		}
		else if (day == 2){
			sDay = "TUESDAY";
			sNiceDay = "�������";
		}
		else if (day == 3) {
			sDay = "WEDNESDAY";
			sNiceDay = "�����";
		}
		else if (day == 4) {
			sDay = "THURSDAY";
			sNiceDay = "�������";
		}
		
		else if (day == 5) {
			sDay = "FRIDAY";
			sNiceDay = "�������";
		}
		else {
			sDay = "vakancy";
			sNiceDay = "��������!";
		}
		
		boolean evenWeek = true;
		if (week%2==0) {
			evenWeek = true;
		}
		else evenWeek = false;
		String sWeek = "";
		String sNiceWeek = "";
		if (evenWeek) {
			sWeek = "FIRSTWEEK";
			sNiceWeek = "������� ������";
		}
		else if (!evenWeek) {
			sWeek = "SECONDWEEK";
			sNiceWeek = "������ ������";
		}
				
		
		if (day == 6 || day == 7) {
			return "����������, ������� �� ��������!!!";
			
		}
		
		String result = "";
		
		
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:schedule.db");
	      c.setAutoCommit(false);
	      

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM SCHEDULE;" );
	      result += "���������� �� " + sNiceDay + " " + sNiceWeek + "\n";
	      while ( rs.next() ) {
	         
	         String  time = rs.getString("TIME");
	         String SCHEDULE  = rs.getString(sWeek+sDay);
	        
	         result += time + "\n" + SCHEDULE + "\n";
	      }
	     
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");

	    return result;
	}
	
}