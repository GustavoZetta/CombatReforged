package com.zetagroup.combatreforged;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.logging.Level;

public class MessageManager {
    public void sendChatMessage(List<String> Message) {
        for (int i = 0; i <= Message.size(); i++) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message.get(i));
            translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(translatedmsg);
            }
        }
    }
    public void sendChatMessage(String Message) {
        String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message);
        translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(translatedmsg);
        }
    }
    public void sendConsoleMessage(Level Level, List<String> Message) {
        for (int i = 0; i <= Message.size(); i++) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message.get(i));
            translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

            Bukkit.getLogger().log(Level, translatedmsg);
        }
    }
    public void sendConsoleMessage(Level Level, String Message) {
        String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message);
        translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

        Bukkit.getLogger().log(Level, translatedmsg);
    }
    public void sendPlayerMessage(Player player, List<String> Message) {
        for (int i = 0; i <= Message.size(); i++) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message.get(i));
            translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

            player.sendMessage(translatedmsg);
        }
    }
    public void sendPlayerMessage(Player player, String Message) {
        String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message);
        translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

        player.sendMessage(translatedmsg);
    }
    public void sendGlobalMessage(Level Level, List<String> Message) {
        for (int i = 0; i <= Message.size(); i++) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message.get(i));
            translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(translatedmsg);
            }

            Bukkit.getLogger().log(Level, translatedmsg);
        }
    }
    public void sendGlobalMessage(List<String> Message) {
        for (int i = 0; i <= Message.size(); i++) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message.get(i));
            translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(translatedmsg);
            }

            Bukkit.getLogger().log(Level.INFO, translatedmsg);
        }
    }
    public void sendGlobalMessage(Level Level, String Message) {
        String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message);
        translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(translatedmsg);
        }

        Bukkit.getLogger().log(Level, translatedmsg);
    }
    public List<String> translateList(List<String> Message) {
        List<String> translatedMessages = List.of();

        for (int i = 0; i <= Message.size(); i++) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message.get(i));
            translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

            translatedMessages.add(translatedmsg);
        }

        return translatedMessages;
    }
    public String translateString(String Message) {
        String translatedmsg = ChatColor.translateAlternateColorCodes('&', Message);
        translatedmsg = ChatColor.translateAlternateColorCodes('§', translatedmsg);

        return translatedmsg;
    }
}
