package com.github.ukraine1449.queststest.Mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CachedPlayer {
    public ArrayList<Integer> progress = new ArrayList<Integer>();
    public Player player;
    public CachedPlayer(Player p){
        p = player;
    }
    public void loadToDB(){
        if(!progress.isEmpty()){
            MongoCon mc = new MongoCon();
            DBObject dbo = new BasicDBObject("_id", player.getUniqueId())
                    .append("Cows", progress.get(0))
                    .append("Walked", progress.get(1))
                    .append("Fish", progress.get(2))
                    .append("Broken", progress.get(3))
                    .append("Broken", progress.get(4))
                    .append("Placed", progress.get(5))
                    .append("Apples", progress.get(6))
                    .append("Strength", progress.get(7))
                    .append("Enchanted", progress.get(8))
                    .append("Compass", progress.get(9));
            mc.insertToDB(dbo);
        }else{
            System.out.println("Prograss list is empty");
        }
    }
}
