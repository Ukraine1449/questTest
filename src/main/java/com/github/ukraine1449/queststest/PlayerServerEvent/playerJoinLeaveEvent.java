package com.github.ukraine1449.queststest.PlayerServerEvent;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerJoinLeaveEvent implements Listener {
QuestsTest plugin;

    public playerJoinLeaveEvent(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event){
        plugin.onlinePlayers.add(event.getPlayer());
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLeave(PlayerQuitEvent event){
        plugin.onlinePlayers.remove(event.getPlayer());
        CachedPlayer cp = new CachedPlayer(event.getPlayer());
        cp.loadToDB();
    }

}
