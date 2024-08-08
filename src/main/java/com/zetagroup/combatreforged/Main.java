package com.zetagroup.combatreforged;

import com.zetagroup.combatreforged.Classes.Bard;
import com.zetagroup.combatreforged.Commands.Class;
import com.zetagroup.combatreforged.Commands.Combo;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // ################
        // #   MANAGERS   #
        // ################
        MessageManager messageInstance = new MessageManager();
        ConfigManager configInstance = new ConfigManager(this, messageInstance);

        // ################
        // #   COMMANDS   #
        // ################
        Class command_ClassInstance = new Class(configInstance);
        Combo command_FlingmeInstance = new Combo(configInstance, messageInstance);
        this.getCommand("class").setExecutor(command_ClassInstance);
        this.getCommand("flingme").setExecutor(command_FlingmeInstance);

        // ################
        // # CONFIG FILES #
        // ################
        configInstance.saveDefaultFile("classes/swashbuckler.yml");
        configInstance.saveDefaultFile("messages/msgcommands.yml");
        configInstance.saveDefaultFile("messages/msglog.yml");
        configInstance.saveDefaultFile("commands.yml");
        configInstance.saveDefaultFile("config.yml");

        // ################
        // #    CLASSES   #
        // ################
        Bard class_BardInstance = new Bard(configInstance, messageInstance);
    }

    @Override
    public void onDisable() {

    }
}
