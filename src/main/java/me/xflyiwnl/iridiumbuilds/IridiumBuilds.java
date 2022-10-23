package me.xflyiwnl.iridiumbuilds;

import com.palmergames.bukkit.towny.TownyCommandAddonAPI;
import com.palmergames.bukkit.towny.object.AddonCommand;
import me.xflyiwnl.iridiumbuilds.commands.BuildsCommand;
import me.xflyiwnl.iridiumbuilds.configuration.BuildsConfiguration;
import me.xflyiwnl.iridiumbuilds.objects.Build;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class IridiumBuilds extends JavaPlugin {

    public static IridiumBuilds instance;

    public static IridiumBuilds getInstance() {
        return instance;
    }

    private PluginManager pluginManager;
    private Plugin towny;

    @Override
    public void onEnable() {

        instance = this;

        pluginManager = Bukkit.getPluginManager();
        towny = pluginManager.getPlugin("Towny");
        if (towny == null) {
            Bukkit.getLogger().info(ChatColor.RED + "IridiumIdeology | Towny не обнаружено");
            Bukkit.getLogger().info(ChatColor.RED + "IridiumIdeology | IridiumIdeology был выключен");

            pluginManager.disablePlugin(this);
        } else {
            Bukkit.getLogger().info(ChatColor.GREEN + "IridiumIdeology | Подключение к Towny");
            Bukkit.getLogger().info(ChatColor.GREEN + "IridiumIdeology | IridiumIdeology был включен");
        }

        BuildsConfiguration.generateDatabaseYaml();

        setupBuilds();
        setupCommands();
    }

    /*
            builds
     */

    public Set<Build> builds = new HashSet<Build>();

    public Set<Build> getBuilds() {
        return builds;
    }

    public Build getBuild(String name) {
        for (Build build : builds) {
            if (build.getName().equals(name)) {
                return build;
            }
        }
        return null;
    }

    public Build getBuild(Build bd) {
        for (Build build : builds) {
            if (build.getName().equals(bd.getName())) {
                return build;
            }
        }
        return null;
    }

    public void setupBuilds() {

        builds.add(new Build("Резиденция"));
        builds.add(new Build("Рынок"));
        builds.add(new Build("Крепость"));
        builds.add(new Build("Порт"));
        builds.add(new Build("Верфь"));
        builds.add(new Build("Университет"));
        builds.add(new Build("Лаборатория"));
        builds.add(new Build("Аэропорт"));
        builds.add(new Build("Оружейный завод"));
        builds.add(new Build("Авиационный завод"));
        builds.add(new Build("Металлообрабатывающий завод"));
        builds.add(new Build("Склад"));

    }

    /*
            commands
     */

    public HashMap<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>();

    public HashMap<String, CommandExecutor> getCommands() {
        return commands;
    }

    public void setupCommands() {

        AddonCommand builds = new AddonCommand(TownyCommandAddonAPI.CommandType.TOWN, "builds", new BuildsCommand());
        TownyCommandAddonAPI.addSubCommand(builds);

    }

}
