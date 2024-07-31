package com.zetagroup.combatreforged.Events;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class PlayerEvents implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender player, Command command, String string, String[] arguments) {
        if (player instanceof Player){
        String  str = "flingme";
        if (command.getLabel() == str){
            ((Player) player).setVelocity(Player) ((Player) player).set;
        }
        }

        return false;
    }
}
