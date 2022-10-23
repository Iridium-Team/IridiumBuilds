package me.xflyiwnl.iridiumbuilds.listeners;

import com.palmergames.bukkit.towny.event.RenameNationEvent;
import com.palmergames.bukkit.towny.event.RenameTownEvent;
import me.xflyiwnl.iridiumbuilds.configuration.BuildsConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CityRename implements Listener {

    /*
     *       nation rename event
     */

    @EventHandler
    public void rename(RenameTownEvent event) {

        String cityName = event.getOldName();

        BuildsConfiguration.set("database." + cityName, null);

    }

}
