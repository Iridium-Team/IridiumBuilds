package me.xflyiwnl.iridiumbuilds.objects;

import com.palmergames.bukkit.towny.object.Town;

import java.util.HashSet;
import java.util.Set;

public class CityBuilds {

    public Town town;

    public Set<Build> builds = new HashSet<Build>();

    public CityBuilds(Town town) {
        this.town = town;
    }

    public void addBuild(Build build) {
        builds.add(build);
    }

    public void removeBuild(Build build) {
        for ()
    }

}
