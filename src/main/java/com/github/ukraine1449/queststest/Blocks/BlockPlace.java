package com.github.ukraine1449.queststest.Blocks;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
    QuestsTest plugin;

    public BlockPlace(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
        public void onBlockPlace(BlockPlaceEvent event){
            Player player = event.getPlayer();
            CachedPlayer cp = CachedPlayer.get(player);
            Integer placed = cp.progress.get(4)+1;
            cp.progress.set(4, placed);
            if(placed == plugin.getConfig().getInt("BlockPlaceAchievementCount")){
                String msg = plugin.getConfig().getString("Achivement-message");
                if(msg != null) {
                    msg = msg.replace("%player%", player.getName());
                    msg = msg.replace("%achivement%", "Block placing");
                }
                player.sendMessage(msg);
            }
        }
}
