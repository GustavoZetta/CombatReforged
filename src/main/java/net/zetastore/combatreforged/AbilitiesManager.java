package net.zetastore.combatreforged;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.logging.Level;


public class AbilitiesManager implements Listener {

    ItemStack ErrorItem = new ItemStack(Material.BARRIER);
    ItemStack MainItem;
    String ItemTag;

    public AbilitiesManager(ConfigManager config, MessageManager message, ItemStack Item, String ItemTag) {
        try {

        } catch (Exception error) {
            ItemMeta meta = ErrorItem.getItemMeta();
            message.sendConsoleMessage(Level.SEVERE, "&cThere was a error while loading an item");
            error.printStackTrace();
            meta.setDisplayName(message.translateString("&cError getting item"));
            ErrorItem.setItemMeta(meta);
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent DropEvent) {


        DropEvent.setCancelled(true);
    }

    @EventHandler
    public void onItemUsed(PlayerInteractEvent InteractEvent) {


        InteractEvent.setCancelled(true);
    }


}
