package com.github.ukraine1449.queststest.MobInteractions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class Fishing implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFishCatch(PlayerFishEvent event){
        Player player = event.getPlayer();
        //TODO Do achievement stuff
    }
}
