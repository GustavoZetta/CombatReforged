package net.zetastore.combatreforged.Classes;

import net.zetastore.combatreforged.ConfigManager;
import net.zetastore.combatreforged.MessageManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SwashBuckler {
    ConfigManager Config;
    MessageManager Message;
    YamlConfiguration MainConfig;

    public SwashBuckler(ConfigManager config, MessageManager msg) {
        Config = config;
        Message = msg;
        MainConfig = Config.getFile("classes/bard.yml");
    }

    public void Lunge(Player player) {
        Vector unitVector = new Vector(player.getLocation().getDirection().getX(), player.getLocation().getDirection().getY() , player.getLocation().getDirection().getZ());
        unitVector = unitVector.normalize();
        player.setVelocity(unitVector.multiply(MainConfig.getDouble("abilities.lunge.velocity")));
        Message.sendPlayerMessage(player, "&cYou used your lunge ability!");
    }
}
