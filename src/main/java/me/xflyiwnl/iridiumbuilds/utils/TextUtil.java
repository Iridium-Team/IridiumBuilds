package me.xflyiwnl.iridiumbuilds.utils;

import org.bukkit.ChatColor;

public class TextUtil {

    /*
     *       hex color
     */

    public static String hex(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg.
                replaceAll("#([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])", "&x&$1&$2&$3&$4&$5&$6"));
    }


}
