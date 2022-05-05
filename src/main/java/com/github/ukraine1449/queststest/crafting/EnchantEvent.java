package com.github.ukraine1449.queststest.crafting;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class EnchantEvent implements Listener {
QuestsTest plugin;

    public EnchantEvent(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEnchant(EnchantItemEvent event){
        ItemMeta meta = event.getItem().getItemMeta();
        if(Objects.equals(event.getItem(), new ItemStack(Material.DIAMOND_SWORD)) && meta.hasEnchant(Enchantment.DAMAGE_ALL)){
            if(meta.getEnchantLevel(Enchantment.DAMAGE_ALL) == plugin.getConfig().getInt("EnchantAchievementLevel")){
                CachedPlayer cp = CachedPlayer.get(event.getEnchanter());
                cp.updateDB(7, plugin.getConfig().getString("Achivement-message"), plugin.getConfig().getInt("Enchantment-count"), "weapon enchanting");
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), plugin.getConfig().getString("command-to-be-run"));
            }
        }
    }

}
