package me.parpar8090.serverplugins.main;

import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class BlockLava implements Listener {
	@EventHandler
	public void blockPlace(PlayerBucketEmptyEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockClicked();

		if(e.getBucket() == Material.LAVA_BUCKET){
			List<Player> players = b.getWorld().getPlayers();
			for(int i = 0; i < players.size(); i++){
				Player target = players.get(i);
				Location loc = target.getLocation();
				if(!target.equals(p) && target.getGameMode() == GameMode.SURVIVAL && p.canSee(target) 
						&& b.getY() >= loc.getBlockY() - 1 && loc.distanceSquared(b.getLocation()) < 10 * 10){
					p.sendMessage("§c§lHey! §7Placing lava near players is not allowed!");
					e.setCancelled(true);
					return;
				}
			}
		}
		e.setCancelled(false);
	}
}
