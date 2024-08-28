package net.zetastore.combatreforged;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.logging.Level;


public class AbilitiesManager implements Listener {
    ItemStack ErrorItem = new ItemStack(Material.BARRIER);
    ItemStack MainItem;
    String ItemTag;

    public HashMap<Player, Integer> hassy = new HashMap<>();
    //                          name of my cute lil hasmap

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
    public void onJoin(PlayerJoinEvent e) {
        hassy.put(e.getPlayer(), 0);
    }
    
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent  dropItemEvent) {
        Player tehPlayer = dropItemEvent.getPlayer();
        int value = hassy.get(tehPlayer.getPlayer());
        if (value >= 2) {
            Vector unitVector = new Vector(tehPlayer.getLocation().getDirection().getX(), tehPlayer.getLocation().getDirection().getY() , tehPlayer.getLocation().getDirection().getZ());
            unitVector = unitVector.normalize();
            tehPlayer.setVelocity(unitVector.multiply(2.5));
            hassy.replace(tehPlayer, 0);
        }
        else {
            hassy.replace(tehPlayer, value + 1);
        }
        dropItemEvent.setCancelled(true);
    }

    @EventHandler
    public void onItemSwitch(PlayerSwapHandItemsEvent switchItemEvent) {
        Player tehPlayer = switchItemEvent.getPlayer();
        int value = hassy.get(tehPlayer.getPlayer());

        switchItemEvent.setCancelled(true);
    }


}
