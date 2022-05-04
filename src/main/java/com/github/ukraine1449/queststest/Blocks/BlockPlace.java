package com.github.ukraine1449.queststest.Blocks;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {
        @EventHandler(priority = EventPriority.HIGHEST)
        public void onBlockPlace(BlockPlaceEvent event){
            Player player = event.getPlayer();
            CachedPlayer cp = CachedPlayer.get(player);
            cp.progress.set(4, cp.progress.get(4)+1);    }
}
