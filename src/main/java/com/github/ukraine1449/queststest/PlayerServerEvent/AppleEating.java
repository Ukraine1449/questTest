package com.github.ukraine1449.queststest.PlayerServerEvent;

import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class AppleEating implements Listener {
    QuestsTest plugin;

    public AppleEating(QuestsTest plugin) {
        this.plugin = plugin;
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onGappleEat(PlayerItemConsumeEvent event){
        if(Objects.equals(event.getItem(), new ItemStack(Material.GOLDEN_APPLE))){
            //TODO Do achivement stuff
        }
    }
}
