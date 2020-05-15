package me.parpar8090.serverplugins.main;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathSound implements Listener{
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = e.getEntity();
			Location loc = p.getLocation();
			try {
				p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.790899F);
				Thread.sleep(250);
				p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.740896F);
				Thread.sleep(250);
				p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.693701F);
				Thread.sleep(250);
				p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.649154F);
				Thread.sleep(350);
				p.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 10, 1F);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
}
