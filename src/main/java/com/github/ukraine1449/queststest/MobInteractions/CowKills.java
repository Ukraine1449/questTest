package com.github.ukraine1449.queststest.MobInteractions;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CowKills implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCowDeath(EntityDamageByEntityEvent event){
        if(event.getEntity().getType() == EntityType.COW && event.getEntity().isDead() && event.getDamager() instanceof Player){
            Player player = (Player) event.getDamager();
            //TODO Do achievement stuff
        }
    }
}
