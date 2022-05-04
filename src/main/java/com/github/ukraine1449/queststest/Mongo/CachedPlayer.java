package com.github.ukraine1449.queststest.Mongo;

import com.avaje.ebean.validation.NotNull;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CachedPlayer {
    public ArrayList<Integer> progress = new ArrayList<Integer>();
    public Player player;
    public static Map<Player, CachedPlayer> map = new HashMap<>();
    public CachedPlayer(Player p){
        p = player;
        map.put(p, this);
    }
    public static CachedPlayer get(Player p) {
        return map.get(p);
    }

    public CachedPlayer remove(Player p) {
        return map.remove(p);
    }

    public void loadToDB(){
        if(!progress.isEmpty()){
            MongoCon mc = new MongoCon();
            DBObject dbo = new BasicDBObject("_id", player.getUniqueId())
                    .append("Cows", progress.get(0))
                    .append("Walked", progress.get(1))
                    .append("Fish", progress.get(2))
                    .append("Broken", progress.get(3))
                    .append("Placed", progress.get(4))
                    .append("Apples", progress.get(5))
                    .append("Strength", progress.get(6))
                    .append("Enchanted", progress.get(7))
                    .append("Compass", progress.get(8));
            mc.insertToDB(dbo);
        }else{
            System.out.println("Prograss list is empty");
        }
    }
    public void loadFromDB(){
        DBObject query = new BasicDBObject("_id", player.getUniqueId());
        MongoCon mc = new MongoCon();
        DBCursor cursor = mc.loadFromDB(query);
        progress.add((Integer) cursor.one().get("Cows"));
        progress.add((Integer) cursor.one().get("Walked"));
        progress.add((Integer) cursor.one().get("Fish"));
        progress.add((Integer) cursor.one().get("Broken"));
        progress.add((Integer) cursor.one().get("Placed"));
        progress.add((Integer) cursor.one().get("Apples"));
        progress.add((Integer) cursor.one().get("Strength"));
        progress.add((Integer) cursor.one().get("Enchanted"));
        progress.add((Integer) cursor.one().get("Compass"));
    }
    public void updateDB(Integer place, String msg, Integer supposed, String ach){
        Integer tbd = progress.get(place)+1;
        progress.set(place, tbd);
        if(tbd.equals(supposed)){
            if(msg != null) {
                msg = msg.replace("%player%", player.getName());
                msg = msg.replace("%achivement%", ach);
            }
            player.sendMessage(msg);
        }
    }
}
