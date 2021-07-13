package com.xditya;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Master{
    public abstract void handleRequest(Update update, String cmd);
}