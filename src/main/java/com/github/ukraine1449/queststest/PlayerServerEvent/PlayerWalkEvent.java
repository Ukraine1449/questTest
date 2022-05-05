package com.github.ukraine1449.queststest.PlayerServerEvent;

import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.QuestsTest;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerStatisticIncrementEvent;

public class PlayerWalkEvent implements Listener {
    QuestsTest plugin;

    public PlayerWalkEvent(QuestsTest plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWali(PlayerStatisticIncrementEvent e){
        if(e.getStatistic() == Statistic.WALK_ONE_CM){
            Integer meterWalk = plugin.getConfig().getInt("distanceToWalk");
            Player player = e.getPlayer();
            if(player.getStatistic(Statistic.WALK_ONE_CM) / 100 >= meterWalk){
                CachedPlayer cp = CachedPlayer.get(player);
                cp.updateDB(1, plugin.getConfig().getString("Achivement-message"), plugin.getConfig().getInt("distanceToWalk"), "hiker");
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), plugin.getConfig().getString("command-to-be-run"));
            }
        }
    }
}
