package net.zetastore.combatreforged;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.logging.Level;

public class MessageManager {
    public void sendChatMessage(List<String> Message) {
        List<String> TranslatedMessages = translateList(Message);
        for (String FinalMessage : TranslatedMessages) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(FinalMessage);
            }
        }
    }
    public void sendChatMessage(String Message) {
        String translatedmsg = translateString(Message);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(translatedmsg);
        }
    }
    public void sendConsoleMessage(Level Level, List<String> Message) {
        List<String> TranslatedMessages = translateList(Message);
        for (String FinalMessage : TranslatedMessages) {
            Bukkit.getLogger().log(Level, FinalMessage);
        }
    }
    public void sendConsoleMessage(Level Level, String Message) {
        String translatedmsg = translateString(Message);

        Bukkit.getLogger().log(Level, translatedmsg);
    }
    public void sendPlayerMessage(Player player, List<String> Message) {
        List<String> TranslatedMessages = translateList(Message);
        for (String FinalMessage : TranslatedMessages) {
            player.sendMessage(FinalMessage);
        }
    }
    public void sendPlayerMessage(Player player, String Message) {
        String translatedmsg = translateString(Message);

        player.sendMessage(translatedmsg);
    }
    public void sendGlobalMessage(Level Level, List<String> Message) {
        List<String> TranslatedMessages = translateList(Message);
        for (String FinalMessage : TranslatedMessages) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(FinalMessage);
            }

            Bukkit.getLogger().log(Level, FinalMessage);
        }
    }
    public void sendGlobalMessage(List<String> Message) {
        List<String> TranslatedMessages = translateList(Message);
        for (String FinalMessage : TranslatedMessages) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(FinalMessage);
            }

            Bukkit.getLogger().log(Level.INFO, FinalMessage);
        }
    }
    public void sendGlobalMessage(Level Level, String Message) {
        String translatedmsg = translateString(Message);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(translatedmsg);
        }

        Bukkit.getLogger().log(Level, translatedmsg);
    }
    public List<String> translateList(List<String> Message) {
        List<String> translatedMessages = List.of();

        for (String msg : translatedMessages) {
            String translatedmsg = ChatColor.translateAlternateColorCodes('&', msg);
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
