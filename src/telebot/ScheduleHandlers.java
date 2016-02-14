package telebot;


import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class ScheduleHandlers extends TelegramLongPollingBot {
	
	private static final String LOGTAG = "SCHEDULEHANDLERS";

    private static final int WAITINGCHANNEL = 1;

    private static final String HELP_TEXT = "Напиши '/schedule', чтобы узнать сегодняшнее расписание";
    private static final String CANCEL_COMMAND = "/stop";
    private static final String AFTER_CHANNEL_TEXT = "A message to provided channel will be sent if the bot was added to it as admin.";
    private static final String WRONG_CHANNEL_TEXT = "Криво написал имя, не забывай добавлять *@* перед ником.";
    private static final String CHANNEL_MESSAGE_TEXT = "Я могу подсказать расписание на сегодня!";
    private static final String ERROR_MESSAGE_TEXT = "Ошибка при отправке сообщения в канал *%s*, ошибка: ```%s```";



    
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        
        if (message != null && message.hasText()) {
        	if (message.getText().startsWith(Commands.scheduleCommand)) {
            sendMessageSchedule(message);
        	}
        }
    }

    @Override
    public String getBotToken() {
        return BotConfig.TOKENSCHEDULE;
    }


    
    public String getBotUsername() {
        return BotConfig.USERNAMESCHEDULE;
    }


    // region Incoming messages handlers

    private void sendMessageSchedule(Message message) {
    	if (message.getText().startsWith(Commands.scheduleCommand)){
    	
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplayToMessageId(message.getMessageId());
        sendMessage.setText(Schedule.takeSchedule());
        sendMessage.enableMarkdown(true);
        

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            sendErrorMessage(message, e.getMessage());
        }
   }
    }
    
    private void sendErrorMessage(Message message, String errorText) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplayToMessageId(message.getMessageId());

        sendMessage.setText(String.format(ERROR_MESSAGE_TEXT, message.getText().trim(), errorText.replace("\"", "\\\"")));
        sendMessage.enableMarkdown(true);

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Ошибка");;
        }
    }
    
}
