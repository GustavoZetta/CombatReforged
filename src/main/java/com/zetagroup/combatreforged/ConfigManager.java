package com.zetagroup.combatreforged;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class ConfigManager {
    Main plugin;
    MessageManager message;

    public ConfigManager(Main Main, MessageManager MessageManager) {
        this.plugin = Main;
        this.message = MessageManager;
    }


    public String getLog(int LogNum) {
        String prefix = "§8[§cCombatReforged§8]§7";

        switch (LogNum) {
            case 404: {
                return message.translateString(prefix + " Error 404: File not Found");
            }
            case 405: {
                return message.translateString(prefix + " Error 405: Path YAML not found");
            }
            case 406: {
                return message.translateString(prefix + " Error 406: File is not a YAML Config file");
            }
            case 407: {
                return message.translateString(prefix + " Error 407: File is not a YAML Config file when saving (this is a major error, please contact the developer)");
            }
            case 408: {
                return message.translateString(prefix + " Error 408: Error while Saving/Loading config file");
            }
            default: {
                return message.translateString(prefix + " Unknown error, please contact the developer");
            }
        }
    }

    public YamlConfiguration getFile(String filepath) {
        if (filepath == null || filepath.trim().isEmpty()) { return null; }

        if (!(filepath.endsWith(".yml"))) {
            message.sendConsoleMessage(Level.WARNING, getLog(406));
            return null;
        }

        File file = new File(plugin.getDataFolder(), filepath);

        if (!file.exists()) {
            message.sendConsoleMessage(Level.WARNING, getLog(404));
            return null;
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        return config;
    }

    public boolean saveFiles(YamlConfiguration fileToSave, String filepath) {
        if (filepath == null || filepath.trim().isEmpty()) { return false; }

        if (filepath.endsWith(".yml")) {
            File file = new File(plugin.getDataFolder(), filepath);

            if (!file.exists()) {
                message.sendConsoleMessage(Level.WARNING, getLog(404));
                return false;
            }

            try {
                fileToSave.save(file);
                return true;
            } catch (IOException error) {
                message.sendConsoleMessage(Level.WARNING, getLog(408));
                return false;
            }
        } else {
            message.sendConsoleMessage(Level.WARNING, getLog(407));
            return false;
        }
    }

    public void saveDefaultFile(String filename) {
        File file = new File(plugin.getDataFolder(), filename);
        if (!file.exists()) {
            plugin.saveResource(filename, false);
        }
    }
}
