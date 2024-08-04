package com.zetagroup.combatreforged;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageManager {
    public void sendChatMessage(List<String> Message) {
        List<String> TranslatedMessages = List.of();

        for (int i = 0; i < 10; i++) {
            TranslatedMessages.add(ChatColor.translateAlternateColorCodes('&', Message.get(i)));
        }

        for (int i = 0; i < 10; i++) {

        }
    }
    public void sendConsoleMessage(String Message) {

    }
    public void sendPlayerMessage(Player player) {

    }
    public void sendMessage() {

    }
}
