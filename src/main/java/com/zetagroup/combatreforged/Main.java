package com.zetagroup.combatreforged;

import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager ConfigInstance = new ConfigManager(); // Initiating the config instance (only one is used for the entire plugin)

    }

    @Override
    public void onDisable() {

    }
}
