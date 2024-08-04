package com.zetagroup.combatreforged;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.logging.Level;

public class ConfigManager {
    Main plugin;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        setFiles();
    }


    public String getLog(int LogNum) { // public function that returns the log messages
        File file = null; // Defining "file"
        YamlConfiguration config = null; // Defining "config"
        String prefix = null; // Defining "prefix" (for messages)
       

        try { // A try executes a function and if any error happens, you can catch that error so the class doesn't crash
            file = new File(plugin.getDataFolder(), "messages/msglog.yml"); // Defining file as a actual file
            config = YamlConfiguration.loadConfiguration(file); // Defining config as a actual config variable
            prefix = config.getString("prefix").replace('&', '§'); // Defining the prefix as the actual log prefix
        } catch (NullPointerException Error) { // Catches the error and send a message to ghe log
            Bukkit.getLogger().log(Level.WARNING, "Error loading log messages, using default stored plugin messages (Delete the file to reset it)");
            prefix = "§8[§cCombatReforged§8]§7"; // Defines prefix as a backup prefix
        }

        switch (LogNum) { // Switch is basically a if but more optimized
            case 404: { // if (LogNum == 404) {...}
                try { // Try to catch any error
                    String msg = config.getString("No File").replace('&', '§'); // replaces the & char with the actual color character
                    msg.replace("{prefix}", prefix); // Transform the "{prefix}" placeholder into the actual prefix
                    return msg; // return the message the plugin got from the config
                } catch (NullPointerException Error) { // Catch any error
                    Bukkit.getLogger().log(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file"); // Sends a warning about the error from the log messages
                    return prefix + " Error 404: File not Found"; // return the backup message
                }
            }
            case 405: { // else if (LogNum == 405) {...}
                try {
                    String msg = config.getString("No Config").replace('&', '§'); // replaces the & char with the actual color character
                    msg.replace("{prefix}", prefix); // Transform the "{prefix}" placeholder into the actual prefix
                    return msg; // return the message the plugin got from the config
                } catch (NullPointerException Error) { // Catch any error
                    Bukkit.getLogger().log(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file"); // Sends a warning about the error from the log messages
                    return prefix + " Error 405: Path YAML not found"; // return the backup message
                }
            }
            case 406: { // else if (LogNum == 406) {...}
                try {
                    String msg = config.getString("Unknown File Type").replace('&', '§'); // replaces the & char with the actual color character
                    msg.replace("{prefix}", prefix); // Transform the "{prefix}" placeholder into the actual prefix
                    return msg; // return the message the plugin got from the config
                } catch (NullPointerException Error) { // Catch any error
                    Bukkit.getLogger().log(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file"); // Sends a warning about the error from the log messages
                    return prefix + " Error 406: File is not a YAML Config file"; // return the backup message
                }
            }
            case 407: { // else if (LogNum == 406) {...}
                try {
                    String msg = config.getString("Wrong File Type When Saving").replace('&', '§'); // replaces the & char with the actual color character
                    msg.replace("{prefix}", prefix); // Transform the "{prefix}" placeholder into the actual prefix
                    return msg; // return the message the plugin got from the config
                } catch (NullPointerException Error) { // Catch any error
                    Bukkit.getLogger().log(Level.WARNING, prefix + " Error while trying to get log messages from the messages/msglog.yml file"); // Sends a warning about the error from the log messages
                    return prefix + " Error 406: File is not a YAML Config file"; // return the backup message
                }
            }
            default: { // else {...} -> Its an default case if other comparations were not found
                return prefix + " Unknown error, please contact the developer"; // return the backup message
            }
        }
    }

    public YamlConfiguration getFile(String filepath) { // Function for getting the file for Yaml(.yml) Configs
        if (filepath == null || filepath.trim().isEmpty()) { return null; } // If the filepath is empty, finishes the function

        if (filepath.endsWith(".yml")) { // If the filetype is a .yml, continues
            File file = new File(Bukkit.getUpdateFolderFile().getPath(), filepath); // Gets the file with the main file path

            if (!file.exists()) { // If file does not exists alredly, sends an error to the console and ends the function
                Bukkit.getLogger().log(Level.WARNING, getLog(404));
                return null;
            }

            YamlConfiguration config = YamlConfiguration.loadConfiguration(file); // Defines the config file

            return config;

        } else { // If file is not a .yml, sends an error to the console and ends the function
            Bukkit.getLogger().log(Level.WARNING, getLog(406));
            return null;
        }
    }

    public boolean saveFiles(YamlConfiguration fileToSave, String filepath) {
        if (filepath == null || filepath.trim().isEmpty()) { return false; } // If the filepath is empty, finishes the function

        if (filepath.endsWith(".yml")) { // If the filetype is a .yml, continues

        } else { // If file is not a .yml, sends an error to the console and ends the function
            Bukkit.getLogger().log(Level.WARNING, getLog(406));
        }
        fileToSave.save(fileToSave);
    }
}
