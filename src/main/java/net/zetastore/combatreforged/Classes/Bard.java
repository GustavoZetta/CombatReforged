package net.zetastore.combatreforged.Classes;

import net.zetastore.combatreforged.ConfigManager;
import net.zetastore.combatreforged.MessageManager;
import org.bukkit.configuration.file.YamlConfiguration;

public class Bard {
    ConfigManager Config;
    MessageManager Message;
    YamlConfiguration MainConfig;

    public Bard(ConfigManager config, MessageManager msg) {
        Config = config;
        Message = msg;
        MainConfig = Config.getFile("classes/bard.yml");
    }
}
