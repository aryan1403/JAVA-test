package com.xditya;

import com.xditya.Plugins.welcome;
import com.xditya.helpers.Config;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        // This will check if the message starts with the Handler
        if(update.getMessage().getText().startsWith(getHandler()))
            sendRequest(update, update.getMessage().getText());
    }

    public void sendRequest(Update update, String cmd){
        new welcome().handleRequest(update, cmd);
    }

    // this func make its easier to send a message to the specified chat.
    public void sendmsg(String chatid, String text) {
        SendMessage msg = new SendMessage(chatid, text);
        msg.enableHtml(true);
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getHandler(){
        return new Config().handler;
    }

    public String getBotUsername() {
        String username = "";
        try{
            User me = getMe();
            username = me.getUserName();
        }
        catch(TelegramApiException e){
            e.printStackTrace();
        }
        if(username != "")
            return username;
        else {
            System.out.println("Getting botUserName from env vars...");
            username = Config.botUserName;
            return username;
        }
    }

    @Override
    public String getBotToken() {
        String token = Config.botToken;
        return token;
    }
}