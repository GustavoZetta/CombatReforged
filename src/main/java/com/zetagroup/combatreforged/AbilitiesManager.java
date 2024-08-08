package com.zetagroup.combatreforged;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class AbilitiesManager {

    ItemStack MainItem;
    HashMap<String, List<String>> Abilities;

    public AbilitiesManager(ItemStack a) {
        MainItem = a;
    }
}
