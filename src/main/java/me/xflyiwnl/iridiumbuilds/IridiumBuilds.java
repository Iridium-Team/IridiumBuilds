package me.xflyiwnl.iridiumbuilds;

import me.xflyiwnl.iridiumbuilds.objects.Build;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class IridiumBuilds extends JavaPlugin {

    public static IridiumBuilds instance;

    public static IridiumBuilds getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
    }

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

}
