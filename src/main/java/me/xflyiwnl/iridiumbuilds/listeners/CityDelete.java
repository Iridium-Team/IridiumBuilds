package me.xflyiwnl.iridiumbuilds.listeners;

import com.palmergames.bukkit.towny.event.DeleteTownEvent;
import me.xflyiwnl.iridiumbuilds.IridiumBuilds;
import me.xflyiwnl.iridiumbuilds.configuration.BuildsConfiguration;
import me.xflyiwnl.iridiumbuilds.objects.CityBuilds;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CityDelete implements Listener {

    /*
     *       nation delete event
     */

    @EventHandler
    public void delete(DeleteTownEvent event) {

        CityBuilds cityBuild = IridiumBuilds.getInstance().getCityBuild(event.getTownName());

        IridiumBuilds.getInstance().getCityBuilds().remove(cityBuild);
        BuildsConfiguration.set("database." + cityBuild.getTown().getName(), null);

    }

}
