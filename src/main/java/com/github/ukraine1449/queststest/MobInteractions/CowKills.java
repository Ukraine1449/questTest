package com.github.ukraine1449.queststest.MobInteractions;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CowKills implements Listener {
    QuestsTest plugin;

    public CowKills(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCowDeath(EntityDamageByEntityEvent event){
        if(event.getEntity().getType() == EntityType.COW && event.getEntity().isDead() && event.getDamager() instanceof Player){
            Player player = (Player) event.getDamager();
            CachedPlayer cp = CachedPlayer.get(player);
            cp.updateDB(0, plugin.getConfig().getString("Achivement-message"), plugin.getConfig().getInt("Cow-kills"), "Cow executioner");
        }
    }
}
