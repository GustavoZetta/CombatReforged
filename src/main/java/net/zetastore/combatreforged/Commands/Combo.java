package net.zetastore.combatreforged.Commands;


import net.zetastore.combatreforged.ConfigManager;
import net.zetastore.combatreforged.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


public class Combo implements CommandExecutor {
    public String cmd = "flingme"; // Defining the "/flingme" command (can't set this as a comment cause its being used)

    ConfigManager Config;
    MessageManager Message;
    YamlConfiguration MainConfig;

    public Combo(ConfigManager configManager, MessageManager messageManager) {
        Config = configManager;
        Message = messageManager;
        MainConfig = Config.getFile("classes/swashbuckler.yml");
    }

    @Override
    // this was not the way i origanlly planned on doing this, my intent was to use combo lock instead
    public boolean onCommand(CommandSender sender, Command command, String commandname, String[] arguments) {
        if (!(commandname.equals(cmd))) { return true; } // If the command name executed is not "/class", end the function by returning "true" for "Executed Right"
        if (!(sender instanceof Player)) { return true; } // If the sender of the command is not a player, end the function by returning "true" for "Executed Right"
        // If any function return false then it will show the default paper error message
        // If it returns true, the message will not appear
        Player player = (Player) sender; // Defining the sender as a player, since now we know its really a player
        Vector unitVector = new Vector(player.getLocation().getDirection().getX(), player.getLocation().getDirection().getY() , player.getLocation().getDirection().getZ());
        unitVector = unitVector.normalize();
        player.setVelocity(unitVector.multiply(MainConfig.getDouble("abilities.lunge.velocity")));
        //nice^^^
        Message.sendPlayerMessage(player, "&cYou used your lunge ability!");
        //i think this could get annoying, maybe we should make a cool-down bar instead of a message?
        // yeah, im going to do this now
        return true;
    

    }
    //this is also not what this section is for, this was just a test to see if i understood the langue ^^
    // public boolean PlayerDropItemEvent(Player player, Item drop)
    // don't worry, im alredly working in this for you with the events, but i maybe think unstead of droping i think we can have
    // multiple items with diferently abilities in right and left click? (dm me in discord for me to actually do this)

}
