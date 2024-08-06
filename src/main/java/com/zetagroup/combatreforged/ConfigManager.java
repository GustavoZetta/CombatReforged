package com.zetagroup.combatreforged;

import org.bukkit.Bukkit;
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
        setFiles();
    }


    public String getLog(int LogNum) {
        File file = null;
        YamlConfiguration config = null;
        String prefix = null;
       

        try {
            file = new File(plugin.getDataFolder(), "messages/msglog.yml");
            config = YamlConfiguration.loadConfiguration(file);
            prefix = config.getString("prefix").replace('&', '§');
        } catch (NullPointerException Error) {
            message.sendConsoleMessage(Level.WARNING,"Error loading log messages, using default stored plugin messages (Delete the file to reset it)");
            prefix = "§8[§cCombatReforged§8]§7";
        }

        switch (LogNum) {
            case 404: {
                try {
                    String msg = config.getString("No File").replace('&', '§');
                    msg.replace("{prefix}", prefix);
                    return message.translateString(msg);
                } catch (NullPointerException Error) {
                    message.sendConsoleMessage(Level.WARNING,prefix + " Error while trying to get log messages from the messages/msglog.yml file");
                    return message.translateString(prefix + " Error 404: File not Found");
                }
            }
            case 405: {
                try {
                    String msg = config.getString("No Config").replace('&', '§');
                    msg.replace("{prefix}", prefix);
                    return message.translateString(msg);
                } catch (NullPointerException Error) {
                    message.sendConsoleMessage(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file");
                    return message.translateString(prefix + " Error 405: Path YAML not found");
                }
            }
            case 406: {
                try {
                    String msg = config.getString("Unknown File Type").replace('&', '§');
                    msg.replace("{prefix}", prefix);
                    return message.translateString(msg);
                } catch (NullPointerException Error) {
                    message.sendConsoleMessage(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file");
                    return message.translateString(prefix + " Error 406: File is not a YAML Config file");
                }
            }
            case 407: {
                try {
                    String msg = config.getString("Wrong File Type When Saving").replace('&', '§');
                    msg.replace("{prefix}", prefix);
                    return msg + "(this is a major error, please contact the developer)";
                } catch (NullPointerException Error) {
                    message.sendConsoleMessage(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file");
                    return message.translateString(prefix + " Error 407: File is not a YAML Config file when saving (this is a major error, please contact the developer)");
                }
            }
            case 408: {
                try {
                    String msg = config.getString("Error Saving File").replace('&', '§');
                    msg.replace("{prefix}", prefix);
                    return msg;
                } catch (NullPointerException Error) {
                    message.sendConsoleMessage(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file");
                    return message.translateString(prefix + " Error 408: Error while Saving/Loading config file");
                }
            }
            default: {
                return message.translateString(prefix + " Unknown error, please contact the developer");
            }
        }
    }

    public YamlConfiguration getFile(String filepath) {
        if (filepath == null || filepath.trim().isEmpty()) { return null; }

        if (filepath.endsWith(".yml")) {
            File file = new File(plugin.getDataFolder(), filepath);

            if (!file.exists()) {
                message.sendConsoleMessage(Level.WARNING, getLog(404));
                return null;
            }

            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            return config;

        } else {
            message.sendConsoleMessage(Level.WARNING, getLog(406));
            return null;
        }
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

    public boolean setFiles() {
        try {
            saveDefaultFile("classes/bard.yml");
            saveDefaultFile("messages/msgcommands.yml");
            saveDefaultFile("messages/msglog.yml");
            saveDefaultFile("commands.yml");
            saveDefaultFile("config.yml");
            return true;
        } catch (NullPointerException error) {
            message.sendConsoleMessage(Level.WARNING, "Something went wrong (NullPointerException), but it may not affect anything in the plugin");
            return false;
        }
    }

    private void saveDefaultFile(String filename) {
        File file = new File(plugin.getDataFolder(), filename);
        if (!file.exists()) {
            plugin.saveResource(filename, false);
        }
    }
}
