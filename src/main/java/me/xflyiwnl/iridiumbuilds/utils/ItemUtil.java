package me.xflyiwnl.iridiumbuilds.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemUtil {

    public static ItemStack createItemStack(Material material, String name, List<String> list, Integer amount) {

        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(list);

        item.setItemMeta(meta);

        return item;

    }

}
