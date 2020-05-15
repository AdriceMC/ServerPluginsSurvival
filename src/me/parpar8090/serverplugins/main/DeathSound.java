package me.parpar8090.serverplugins.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathSound implements Listener {
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {

		if (e.getEntity() instanceof Player) {
			Player p = e.getEntity();
			Location loc = p.getLocation();

			p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.790899F);

			Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(ServerPlugins.class), new Runnable() {

				@Override
				public void run() {
					p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.740896F);

					Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(ServerPlugins.class), new Runnable() {

						@Override
						public void run() {
							p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.693701F);

							Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(ServerPlugins.class),
									new Runnable() {

										@Override
										public void run() {
											p.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BANJO, 50, 0.649154F);

											Bukkit.getScheduler().runTaskLater(
													JavaPlugin.getPlugin(ServerPlugins.class), new Runnable() {

														@Override
														public void run() {
															p.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE,
																	10, 1F);
														}

													}, 350L);

										}

									}, 250L);

						}

					}, 250L);

				}

			}, 250L);

		}

	}

}
