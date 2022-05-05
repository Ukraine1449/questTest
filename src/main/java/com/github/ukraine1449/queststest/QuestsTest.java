package com.github.ukraine1449.queststest;

import com.github.ukraine1449.queststest.Blocks.BlockBreak;
import com.github.ukraine1449.queststest.Blocks.BlockPlace;
import com.github.ukraine1449.queststest.MobInteractions.CowKills;
import com.github.ukraine1449.queststest.MobInteractions.Fishing;
import com.github.ukraine1449.queststest.Mongo.CachedPlayer;
import com.github.ukraine1449.queststest.Mongo.MongoCon;
import com.github.ukraine1449.queststest.PlayerServerEvent.AppleEating;
import com.github.ukraine1449.queststest.PlayerServerEvent.PlayerWalkEvent;
import com.github.ukraine1449.queststest.PlayerServerEvent.PlayerJoinLeaveEvent;
import com.github.ukraine1449.queststest.crafting.BrewingEvent;
import com.github.ukraine1449.queststest.crafting.CompasCraft;
import com.github.ukraine1449.queststest.crafting.EnchantEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.UnknownHostException;
import java.util.ArrayList;

public final class QuestsTest extends JavaPlugin {
public ArrayList<Player> onlinePlayers = new ArrayList<>();
public static QuestsTest instance;
public MongoCon mongoConnection;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        loadMongo();
        //getCommand("minionconfig").setExecutor(new configGUIOpen(this));
        getServer().getPluginManager().registerEvents(new BlockBreak(this), this);
        getServer().getPluginManager().registerEvents(new BlockPlace(this), this);
        getServer().getPluginManager().registerEvents(new BrewingEvent(this), this);
        getServer().getPluginManager().registerEvents(new CompasCraft(this), this);
        getServer().getPluginManager().registerEvents(new EnchantEvent(this), this);
        getServer().getPluginManager().registerEvents(new CowKills(this), this);
        getServer().getPluginManager().registerEvents(new Fishing(this), this);
        getServer().getPluginManager().registerEvents(new AppleEating(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerWalkEvent(this), this);
    }

    @Override
    public void onDisable() {
        for(Player player : onlinePlayers){
            CachedPlayer cp = CachedPlayer.get(player);
            cp.loadToDB();
            onlinePlayers.remove(player);
        }
    mongoConnection.close();
    }
    private void loadMongo() {
        try {
            mongoConnection = new MongoCon(getConfig().getString("Mongo.host"), getConfig().getInt("Mongo.port"), getConfig().getString("Mongo.database"), getConfig().getString("Mongo.collection"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
//TODO Make GUI
//TODO Make Menu handler
//TODO Register events
//TODO Make /quests command