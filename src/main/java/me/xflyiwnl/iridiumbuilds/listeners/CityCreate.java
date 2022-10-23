package me.xflyiwnl.iridiumbuilds.listeners;

import com.palmergames.bukkit.towny.event.NewNationEvent;
import com.palmergames.bukkit.towny.event.NewTownEvent;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
import me.xflyiwnl.iridiumbuilds.IridiumBuilds;
import me.xflyiwnl.iridiumbuilds.objects.CityBuilds;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CityCreate implements Listener {

    /*
     *       nation create event
     */

    @EventHandler
    public void create(NewTownEvent event) {

        Town city = event.getTown();
        CityBuilds cityBuilds = new CityBuilds(city);

        IridiumBuilds.getInstance().getCityBuilds().add(cityBuilds);

    }

}
