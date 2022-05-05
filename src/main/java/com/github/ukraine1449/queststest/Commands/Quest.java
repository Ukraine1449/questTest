package com.github.ukraine1449.queststest.Commands;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Quest implements CommandExecutor {
QuestsTest plugin;

    public Quest(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Inventory inv = Bukkit.createInventory(player, 9, ChatColor.BLUE+"QuestProgress");
            CachedPlayer cp = CachedPlayer.get(player);
            inv.addItem(createItemStack(Material.RAW_BEEF, "Cow killing progress", cp.progress.get(0) + " Cows killed out of " + plugin.getConfig().getInt("Cow-kills")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Walking progress", cp.progress.get(1) + " meters walked out of " + plugin.getConfig().getInt("distanceToWalk")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Fish catching progress", cp.progress.get(2) + " Fish caught out of " + plugin.getConfig().getInt("Fish-caught")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Block breaking progress", cp.progress.get(3) + " Blocks broken out of " + plugin.getConfig().getInt("BlockRemoveAchievementCount")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Block placing progress", cp.progress.get(4) + " Blocks placed out of " + plugin.getConfig().getInt("BlockPlaceAchievementCount")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Apple eating progress", cp.progress.get(5) + " Gapples eaten out of " + plugin.getConfig().getInt("Gapples-eaten")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Strength brewing progress", cp.progress.get(6) + " Strength potions brewed out of " + plugin.getConfig().getInt("Supposed-potions")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Enchanting progress", cp.progress.get(7) + " Diamond swords enchanted with sharpness 1 out of " + plugin.getConfig().getInt("Enchantment-count")));
            inv.addItem(createItemStack(Material.RAW_BEEF, "Compass progress", cp.progress.get(8) + " Compasses crafted out of " + plugin.getConfig().getInt("Supposed-compass")));
            player.openInventory(inv);
        }
        return false;
    }
    public ItemStack createItemStack(Material material, String name, String description){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta isl = itemStack.getItemMeta();
        isl.setDisplayName(name);
        ArrayList<String> isla = new ArrayList<>();
        isla.add(description);
        isl.setLore(isla);
        itemStack.setItemMeta(isl);
        return itemStack;
    }
}
