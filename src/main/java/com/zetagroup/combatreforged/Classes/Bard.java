package com.zetagroup.combatreforged.Classes;

import com.zetagroup.combatreforged.ConfigManager;
import com.zetagroup.combatreforged.MessageManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Bard {
    ConfigManager Config;
    MessageManager Message;
    YamlConfiguration MainConfig;

    public Bard(ConfigManager config, MessageManager msg) {
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
