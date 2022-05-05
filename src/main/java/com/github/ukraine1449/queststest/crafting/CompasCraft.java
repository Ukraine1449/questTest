package com.github.ukraine1449.queststest.crafting;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CompasCraft implements Listener {
QuestsTest plugin;

    public CompasCraft(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCompassCraft(CraftItemEvent event){
        if(event.getResult().name().equals("Compass")){
            CachedPlayer cp = CachedPlayer.get((Player) event.getInventory().getViewers().get(0));
            cp.updateDB(8, plugin.getConfig().getString("Achivement-message"), plugin.getConfig().getInt("Supposed-compass"), "Compass crafting");
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), plugin.getConfig().getString("command-to-be-run"));

        }
    }

}
