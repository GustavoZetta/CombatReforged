package com.zetagroup.combatreforged;

import com.zetagroup.combatreforged.Commands.Class;
import com.zetagroup.combatreforged.Commands.Combo;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigManager configInstance = new ConfigManager(this); // Initiating the config instance (only one is used for the entire plugin)
        Class command_ClassInstance = new Class(configInstance);
        Combo command_FlingmeInstance = new Combo(configInstance);

        this.getCommand(command_ClassInstance.cmd).setExecutor(command_ClassInstance);
        this.getCommand(command_FlingmeInstance.cmd).setExecutor(command_FlingmeInstance);
    }

    @Override
    public void onDisable() {

    }
}
