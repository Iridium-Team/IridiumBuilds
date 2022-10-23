package me.xflyiwnl.iridiumbuilds.configuration;

import me.xflyiwnl.iridiumbuilds.IridiumBuilds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BuildsConfiguration {

    private static File databaseFile;
    private static YamlConfiguration databaseYaml;

    public static void generateDatabaseYaml() {

        databaseFile = new File(IridiumBuilds.getInstance().getDataFolder(), "database.yml");
        if (!databaseFile.exists()) {
            IridiumBuilds.getInstance().saveResource("database.yml", true);
            Bukkit.getLogger().info(ChatColor.RED + "IridiumBuilds | Конфигурационный файл database.yml не найден, создаю его в новом облике...");
        }
        databaseYaml = YamlConfiguration.loadConfiguration(databaseFile);
        Bukkit.getLogger().info(ChatColor.GREEN + "IridiumBuilds | Конфигурационный файл database.yml загружено");

    }

    public static Object get(String path) {
        return databaseYaml.get(path);
    }

    public static void set(String path, Object object) {
        databaseYaml.set(path, object);
        try {
            databaseYaml.save(databaseFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reloadDatabaseYaml() {

        databaseYaml = YamlConfiguration.loadConfiguration(databaseFile);
        Bukkit.getLogger().info(ChatColor.GREEN + "IridiumIdeology | Конфигурационный файл database.yml загружено");

    }

}
