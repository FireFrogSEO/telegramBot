package telebot;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;



public class Main {

	private static final String LOGTAG = "MAIN";

	    public static void main(String[] args) {
	    	
	    	try {
	    		SQLiteJDBC.createTable();
	    	} catch ( Exception e ){
	    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  	      System.exit(0);
	    	}

	        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
	        try {
	            telegramBotsApi.registerBot(new ScheduleHandlers());
	            
	        } catch (TelegramApiException e) {
	            System.out.println("TelegramApi ошибка");;
	        }

	}

}
