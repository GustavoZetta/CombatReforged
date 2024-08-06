package com.zetagroup.combatreforged;

import com.zetagroup.combatreforged.Classes.Bard;
import com.zetagroup.combatreforged.Commands.Class;
import com.zetagroup.combatreforged.Commands.Combo;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        MessageManager messageInstance = new MessageManager(); // Initiating the message instance (only one is used for the entire plugin)
        ConfigManager configInstance = new ConfigManager(this, messageInstance); // Initiating the config instance (only one is used for the entire plugin)
        Class command_ClassInstance = new Class(configInstance);
        Combo command_FlingmeInstance = new Combo(configInstance, messageInstance);

        Bard class_BardInstance = new Bard(configInstance, messageInstance);

        this.getCommand("class").setExecutor(command_ClassInstance);
        this.getCommand("flingme").setExecutor(command_FlingmeInstance);
    }

    @Override
    public void onDisable() {

    }
}
