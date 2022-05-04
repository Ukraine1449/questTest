package com.github.ukraine1449.queststest.PlayerServerEvent;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.entity.Player;
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
        Player player = event.getPlayer();
        plugin.onlinePlayers.add(player);
        CachedPlayer cp = new CachedPlayer(player);
        cp.loadFromDB();
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        plugin.onlinePlayers.remove(player);
        CachedPlayer cp = CachedPlayer.get(player);
        cp.loadToDB();
        cp.remove(event.getPlayer());
    }

}
