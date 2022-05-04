package com.github.ukraine1449.queststest.MobInteractions;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class Fishing implements Listener {
    QuestsTest plugin;

    public Fishing(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFishCatch(PlayerFishEvent event){
        Player player = event.getPlayer();
        CachedPlayer cp = CachedPlayer.get(player);
        cp.updateDB(2, plugin.getConfig().getString("Achivement-message"), plugin.getConfig().getInt("Fish-caught"), "Fisherman");

    }
}
