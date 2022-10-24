package me.xflyiwnl.iridiumbuilds.objects.gui;

import com.palmergames.bukkit.towny.object.Town;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.PaginatedGui;
import me.xflyiwnl.iridiumbuilds.IridiumBuilds;
import me.xflyiwnl.iridiumbuilds.objects.Build;
import me.xflyiwnl.iridiumbuilds.objects.CityBuilds;
import me.xflyiwnl.iridiumbuilds.utils.ItemUtil;
import me.xflyiwnl.iridiumbuilds.utils.TextUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class CityBuildsGUI {

    public Player player;
    public Town town;

    public ItemStack border = ItemUtil.createItemStack(
            Material.LIME_STAINED_GLASS_PANE,
            TextUtil.hex("#50D790Барьер :)"),
            Arrays.asList(" &7Как же хочется закончить этот плагин", " &7устал его писать..."),
            1);

    public List<Integer> borderSlot = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 18,
            19, 27,
            28, 36,
            37, 45,
            46, 47, 48, 50, 52, 53, 54
    );

    public ItemStack nextItem = ItemUtil.createItemStack(
            Material.PAPER,
            TextUtil.hex("#50D790Следующая страница ->"),
            null,
            1);

    public ItemStack previousItem = ItemUtil.createItemStack(
            Material.PAPER,
            TextUtil.hex("#50D790<- Предыдущая страница"),
            null,
            1);

    public CityBuildsGUI(Player player, Town town) {
        this.player = player;
        this.town = town;

        generateGUI(player, town);
    }

    public void generateGUI(Player player, Town town) {

        PaginatedGui paginatedGui = Gui.paginated().rows(6).create();
        baseGuiItems(paginatedGui);

        CityBuilds cityBuilds = IridiumBuilds.getInstance().getCityBuild(town);

        for (Build build : cityBuilds.getBuilds()) {
            //todo
        }

        // 1
        // 2

        paginatedGui.open(player);

    }

    public void baseGuiItems(PaginatedGui paginatedGui) {

        GuiItem border = ItemBuilder.from(this.border).asGuiItem(event -> {
            event.getWhoClicked().sendMessage(TextUtil.hex("&7Разработано xflyiwnl & IridiumStudio"));
            event.setResult(Event.Result.DENY);
        });

        for (Integer i : borderSlot) {
            paginatedGui.setItem(i, border);
        }

        GuiItem next = ItemBuilder.from(this.nextItem).asGuiItem(event -> {
            paginatedGui.next();
            event.setResult(Event.Result.DENY);
        });
        paginatedGui.setItem(49, next);

        GuiItem previous = ItemBuilder.from(this.previousItem).asGuiItem(event -> {
            paginatedGui.previous();
            event.setResult(Event.Result.DENY);
        });
        paginatedGui.setItem(51, previous);

    }

}
