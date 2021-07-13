package com.xditya.Plugins;

import com.xditya.Master;
import com.xditya.bot;

import org.telegram.telegrambots.meta.api.objects.Update;

public class welcome extends bot implements Master{
    public void handleRequest(Update update, String cmd) {
        // This will check if the Update message is a Plugin cmd or not
        // getHandler() = / + cmd
        if(cmd.equalsIgnoreCase(getHandler()+"welcome")){
            sendmsg(update.getMessage().getChatId().toString(), "Welcome to Test Bot XD");
        }
    }
}