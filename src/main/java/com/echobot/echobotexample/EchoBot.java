// Defining Package name
package com.echobot.echobotexample;

// @Value annotation
import org.springframework.beans.factory.annotation.Value;
// @Component annotation
import org.springframework.stereotype.Component;
// LongPollingBot class
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
// Update Method
import org.telegram.telegrambots.meta.api.objects.Update;
// SendMessage method
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
class EchoBot extends TelegramLongPollingBot {

    String BOT_TOKEN = "5601481368:AAEVchNDykkiShpfR3J_YXSfW0o8ZnRKWFI";
    String BOT_USERNAME = "ipoReminderBot";


    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Creating object of SendMessage
            SendMessage message = new SendMessage();
            // Setting chat id
            message.setChatId(update.getMessage().getChatId().toString());
            // Setting reply to message id
            message.setReplyToMessageId(update.getMessage().getMessageId());
            // Getting and setting received message text
            message.setText(update.getMessage().getText());
            try {
                // Sending message
                execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}