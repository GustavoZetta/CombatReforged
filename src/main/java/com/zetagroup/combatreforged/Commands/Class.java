package com.zetagroup.combatreforged.Commands;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Class implements CommandExecutor {

    YamlConfiguration config = null;
    
    public Class(ConfigManager configfile) {
        config = configfile;
    }
    
    static String cmd = "class"; // Defining the "/class" command as a "static" for less RAM usage
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] arguments) {
        if (!(command.getName().equals(cmd))) { return true; } // If the command name executed is not "/class", end the function by returning "true" for "Executed Right"
        if (!(sender instanceof Player)) { return true; } // If the sender of the command is not a player, end the function by returning "true" for "Executed Right"
        // If any function return false then it will show the default paper error message
        // If it returns true, the message will not appear
        Player player = (Player) sender; // Defining the sender as a player, since now we know its really a player

        // I'll be using that for the class selection menu later

        return true;
    }
}
