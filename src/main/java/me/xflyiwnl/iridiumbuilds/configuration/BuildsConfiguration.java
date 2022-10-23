package me.xflyiwnl.iridiumbuilds.configuration;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
import me.xflyiwnl.iridiumbuilds.IridiumBuilds;
import me.xflyiwnl.iridiumbuilds.objects.Build;
import me.xflyiwnl.iridiumbuilds.objects.CityBuilds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void saveCityBuilds() {

        for (CityBuilds cityBuilds : IridiumBuilds.getInstance().getCityBuilds()) {

            List<String> builds = new ArrayList<String>();

            for (Build build : cityBuilds.getBuilds()) {
                builds.add(build.getName());
            }

            set("database." + cityBuilds.getTown().getName() + ".builds", builds);

        }

    }

    public static void loadCityBuilds() {

        if (!databaseYaml.isConfigurationSection("database")) {
            return;
        }

        for (String section : databaseYaml.getConfigurationSection("database").getKeys(false)) {

            Town city = TownyAPI.getInstance().getTown(section);
            List<String> buildsList = (List<String>) get("database." + section + ".builds");

            Set<Build> buildSet = new HashSet<Build>();

            for (String str : buildsList) {
                buildSet.add(IridiumBuilds.getInstance().getBuild(str));
            }

            CityBuilds cityBuilds = new CityBuilds(city, buildSet);
            IridiumBuilds.getInstance().getCityBuilds().add(cityBuilds);

        }

    }

}
