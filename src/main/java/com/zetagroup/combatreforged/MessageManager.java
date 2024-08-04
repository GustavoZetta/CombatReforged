package com.zetagroup.combatreforged;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageManager {
    public void sendChatMessage(List<String> Message) {
        for (int i = 0; i < Message.size(); i++) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message.get(i));
            translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(translatedmsg);
            }
        }
    }
    public void sendConsoleMessage(String Message) {

    }
    public void sendPlayerMessage(Player player) {

    }
    public void sendMessage() {

    }
}
