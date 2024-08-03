package com.zetagroup.combatreforged;

import com.zetagroup.combatreforged.Commands.Class;
import com.zetagroup.combatreforged.Commands.Combo;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager configInstance = new ConfigManager(this); // Initiating the config instance (only one is used for the entire plugin)
        Class commandClassInstance = new Class(configInstance);
        Combo comboClassInstance = new Combo(configInstance);
    }

    @Override
    public void onDisable() {

    }
}
