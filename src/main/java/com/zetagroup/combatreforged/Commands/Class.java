package com.zetagroup.combatreforged.Commands;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.zetagroup.combatreforged.ConfigManager;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;


public class Class implements CommandExecutor {

    YamlConfiguration config = null;
    public String cmd = "class"; // Defining the "/class" command
    
    public Class(ConfigManager configManager) {
        config = configManager.getFile("resources/config.yml"); //TODO: Check that this is correct path with Gustavo

        try {
            String temp = config.getString("commands.class.name");
            if (!(temp == null) || !(temp.isEmpty())) {
                cmd = temp;
            }
        } catch (NullPointerException Error) {
            Bukkit.getLogger().log(Level.SEVERE, "Error while getting the command.yml, trying to use the default file (it might be broken)");
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] arguments) {
        if (!(command.getName().equals(cmd))) { return true; } // If the command name executed is not "/class", end the function by returning "true" for "Executed Right"
        if (!(sender instanceof Player)) { return true; } // If the sender of the command is not a player, end the function by returning "true" for "Executed Right"
        // If any function return false then it will show the default paper error message
        // If it returns true, the message will not appear
        Player player = (Player) sender; // Defining the sender as a player, since now we know its really a player

        // I'll be using that for the class selection menu later

        return true;
    }
}
