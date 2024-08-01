package com.zetagroup.combatreforged;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.zetagroup.combatreforged.Commands.Class;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager ConfigInstance = new ConfigManager(this); // Initiating the config instance (only one is used for the entire plugin)
        Class cmd_ClassInstance = new Class(ConfigInstance);
        
        YamlConfiguration config = ConfigInstance.getFile("commands.yml");
        String cmd = config.getString("commands.class.name");

        this.getCommand(cmd).setExecutor(cmd_ClassInstance);
    }

    @Override
    public void onDisable() {

    }
}