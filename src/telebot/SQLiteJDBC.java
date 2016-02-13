package telebot;

import java.sql.*;

public class SQLiteJDBC
{
  public static void createTable()
  {
	  Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:schedule.db");
	      c.setAutoCommit(false);

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE if not exists SCHEDULE " +
	                   "(ID INT     NOT NULL," +
	                   " TIME           TEXT    NOT NULL, " + 
	                   " FIRSTWEEKMONDAY     TEXT     NOT NULL, " + 
	                   " SECONDWEEKMONDAY    TEXT NOT NULL, " + 
	                   " FIRSTWEEKTUESDAY    TEXT NOT NULL, " +
	                   " SECONDWEEKTUESDAY    TEXT NOT NULL, " +
	                   " FIRSTWEEKWEDNESDAY    TEXT NOT NULL, " +
	                   " SECONDWEEKWEDNESDAY    TEXT NOT NULL, " +
	                   " FIRSTWEEKTHURSDAY    TEXT NOT NULL, " +
	                   " SECONDWEEKTHURSDAY    TEXT NOT NULL, " +
	                   " FIRSTWEEKFRIDAY      TEXT NOT NULL, " +
	                   " SECONDWEEKFRIDAY    TEXT NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      System.out.println("База создана!");
	      
	      
	      sql = "REPLACE INTO SCHEDULE (ID,TIME,FIRSTWEEKMONDAY,SECONDWEEKMONDAY,FIRSTWEEKTUESDAY,SECONDWEEKTUESDAY,FIRSTWEEKWEDNESDAY,SECONDWEEKWEDNESDAY,FIRSTWEEKTHURSDAY,SECONDWEEKTHURSDAY,FIRSTWEEKFRIDAY,SECONDWEEKFRIDAY) " +
                  "VALUES (0, '8.00-9.35', 'Можно поспать!', 'Хирургия практика, ДКЛ', 'Мед право, 581', 'Педиатрия, ОХМАТДЕТ', 'Лекция по вагинам', 'Лекция по терапии, на которую ты не придешь', 'Практика по вагинам', 'Можно поспать', 'Терапия', 'Терапия' );"; 
     stmt.executeUpdate(sql);

     sql = "REPLACE INTO SCHEDULE (ID,TIME,FIRSTWEEKMONDAY,SECONDWEEKMONDAY,FIRSTWEEKTUESDAY,SECONDWEEKTUESDAY,FIRSTWEEKWEDNESDAY,SECONDWEEKWEDNESDAY,FIRSTWEEKTHURSDAY,SECONDWEEKTHURSDAY,FIRSTWEEKFRIDAY,SECONDWEEKFRIDAY) " +
           "VALUES (1, '9.55-11.30', 'И сейчас спим!', 'Хирургия', 'Домой!', 'Педиатрия, ОХМАТДЕТ', 'Окно', 'Знаешь почему?', 'Практика по вагинам', 'Судмед с 10.40', 'Терапия', 'Терапия' );"; 
     stmt.executeUpdate(sql);

     sql = "REPLACE INTO SCHEDULE (ID,TIME,FIRSTWEEKMONDAY,SECONDWEEKMONDAY,FIRSTWEEKTUESDAY,SECONDWEEKTUESDAY,FIRSTWEEKWEDNESDAY,SECONDWEEKWEDNESDAY,FIRSTWEEKTHURSDAY,SECONDWEEKTHURSDAY,FIRSTWEEKFRIDAY,SECONDWEEKFRIDAY) " +
           "VALUES (2, '11.40-13.15', 'ЛОР лекция, ДКЛ', 'Офтальмология лекция, ДКЛ', 'Дома!', 'Домой!', 'Соцмедицина с 12.25', 'Потому что', 'Неврология с 12.25', 'Судмед', 'Медправо лекция', 'Окно' );"; 
     stmt.executeUpdate(sql);

     sql = "REPLACE INTO SCHEDULE (ID,TIME,FIRSTWEEKMONDAY,SECONDWEEKMONDAY,FIRSTWEEKTUESDAY,SECONDWEEKTUESDAY,FIRSTWEEKWEDNESDAY,SECONDWEEKWEDNESDAY,FIRSTWEEKTHURSDAY,SECONDWEEKTHURSDAY,FIRSTWEEKFRIDAY,SECONDWEEKFRIDAY) " +
           "VALUES (3, '13.25-15.00', 'Офтальмология практика, ДКЛ', 'ЛОР практика, ДКЛ', 'Вкусный обед', 'Дома!', 'Соцмедицина', 'в этот день', 'Неврология', 'Психиатрия', 'Лекция соцмед', 'Медпсихология' );"; 
     stmt.executeUpdate(sql);
     
     sql = "REPLACE INTO SCHEDULE (ID,TIME,FIRSTWEEKMONDAY,SECONDWEEKMONDAY,FIRSTWEEKTUESDAY,SECONDWEEKTUESDAY,FIRSTWEEKWEDNESDAY,SECONDWEEKWEDNESDAY,FIRSTWEEKTHURSDAY,SECONDWEEKTHURSDAY,FIRSTWEEKFRIDAY,SECONDWEEKFRIDAY) " +
	            "VALUES (4, '15.15-16.50', 'Офтальмология практика', 'ЛОР практика', 'Ой, да какая 5-ая пара?', 'Ой, да какая 5-ая пара?', 'Домой', 'это единственная пара!', 'Неврология', 'Психиатрия до 16.00', 'Лекция медпсихология', 'Окно' );"; 
	      stmt.executeUpdate(sql);
	      
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("All right, записи сделаны");
  }
}