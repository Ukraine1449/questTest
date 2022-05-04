package com.github.ukraine1449.queststest.crafting;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;

public class BrewingEvent implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onStrengthBrew(BrewEvent event){
        ArrayList<ItemStack> allPotions = new ArrayList<>();
        for(int i = 0; i <= 3; i++){
            allPotions.add(event.getContents().getItem(i));
        }
        for(ItemStack is : allPotions){
            PotionMeta pm = (PotionMeta) is.getItemMeta();
            if(pm.getCustomEffects().contains(PotionType.STRENGTH)){
                //TODO Do achievement
            }
        }
    }
}
