package com.github.ukraine1449.queststest.crafting;

import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class CompasCraft implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCompassCraft(CraftItemEvent event){
        if(event.getResult().name().equals("Compass")){
            //TODO add achievement code
        }
    }

}
