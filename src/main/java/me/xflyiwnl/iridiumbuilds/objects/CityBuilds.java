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

    public Town getTown() {
        return town;
    }

    public Set<Build> getBuilds() {
        return builds;
    }

    public boolean hasBuild(Build build) {
        for (Build build1 : builds) {
            if (build1.getName().equals(build.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addBuild(Build build) {
        builds.add(build);
    }

    public void removeBuild(Build build) {
        for (Build build1 : builds) {
            if (build1.getName().equals(build.getName())) {
                builds.remove(build);
                break;
            }
        }
    }

}
