package com.github.ukraine1449.queststest.Blocks;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {
    QuestsTest plugin;

    public BlockBreak(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        CachedPlayer cp = CachedPlayer.get(player);
        cp.updateDB(3, plugin.getConfig().getString("Achivement-message"), plugin.getConfig().getInt("BlockRemoveAchievementCount"), "block breaker");
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), plugin.getConfig().getString("command-to-be-run"));
    }
}
//