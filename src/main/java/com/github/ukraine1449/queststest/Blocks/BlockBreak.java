package com.github.ukraine1449.queststest.Blocks;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
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
        Integer broken = cp.progress.get(3)+1;
        cp.progress.set(3, broken);
        if(broken == plugin.getConfig().getInt("BlockRemoveAchievementCount")){
            String msg = plugin.getConfig().getString("Achivement-message");
            if(msg != null) {
                msg = msg.replace("%player%", player.getName());
                msg = msg.replace("%achivement%", "Block breaking");
            }
            player.sendMessage(msg);
        }
    }
}
