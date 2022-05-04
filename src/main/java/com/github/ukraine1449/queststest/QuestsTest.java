package com.github.ukraine1449.queststest;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class QuestsTest extends JavaPlugin {
public ArrayList<Player> onlinePlayers = new ArrayList<>();
    @Override
    public void onEnable() {
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
//TODO Make on disable
//TODO Make GUI
//TODO Make Menu handler
//TODO Register events
//TODO Make /quests command
//TODO Make command execute (look in ticket)
