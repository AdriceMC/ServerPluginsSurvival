package me.parpar8090.serverplugins.main;

import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import me.parpar8090.serverplugins.features.Interactions;
import me.parpar8090.serverplugins.features.commands.Apply;
import me.parpar8090.serverplugins.features.commands.EndCrystal;
import me.parpar8090.serverplugins.features.commands.Leap;
import me.parpar8090.serverplugins.features.commands.TutorialCmd;
 
public final class ServerPlugins extends org.bukkit.plugin.java.JavaPlugin implements Listener{
	
	public void onEnable(){
		System.out.println("//  ServerPlugins Enabled.  //");
		ConfigManager cm = new ConfigManager(this);
		cm.setup(this);
		getCommand("apply").setExecutor(new Apply());
		getCommand("tutorial").setExecutor(new TutorialCmd());
		getCommand("crystal").setExecutor(new EndCrystal());
		//getCommand("friend").setExecutor(new Friend());
		getCommand("leap").setExecutor(new Leap());
		getCommand("viewstats").setExecutor(new Interactions());
		
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new DeathSound(), this);
		getServer().getPluginManager().registerEvents(new BlockLava(), this);
		getServer().getPluginManager().registerEvents(new Interactions(), this);
	}
   
   public void onDisable() {
	   System.out.println("//  ServerPlugin Disabled.  //");
   }
   
   @EventHandler
   public void onPortalEnter(PlayerPortalEvent e) {
	   Player p = e.getPlayer();
	   if(e.isCancelled()) {
           return;
       }
	   Environment DesEnv = e.getTo().getWorld().getEnvironment();
	   if(e.getCause() == PlayerPortalEvent.TeleportCause.NETHER_PORTAL) {
		   if(p.getInventory().contains(Material.DIAMOND_CHESTPLATE) || p.getInventory().contains(Material.DIAMOND_LEGGINGS) 
				   || p.getInventory().contains(Material.DIAMOND_BOOTS) 
				   || p.getInventory().contains(Material.DIAMOND_HELMET) || 
				   p.getInventory().contains(Material.IRON_CHESTPLATE) || 
				   p.getInventory().contains(Material.IRON_LEGGINGS) 
				   || p.getInventory().contains(Material.IRON_BOOTS) 
				   || p.getInventory().contains(Material.IRON_HELMET)) {
			   e.setCancelled(false);
			   p.sendMessage("§dDestination Found! §bAt: §a" + DesEnv + " X:" + e.getTo().getBlockX() 
					   + " Y:" + e.getTo().getBlockY() + " Z:" + e.getTo().getBlockZ());
			   p.sendMessage("");
		   }
		   else {
			   e.setCancelled(true);
			   p.sendMessage("§cYou can't use §dNETHER§c portals until you have a piece of §rIron Armor "
			   		+ "§cor §bDiamond Armor§c in you inventory!");
			   p.sendMessage("");
		   }
	   }
	   else if(e.getCause() == PlayerPortalEvent.TeleportCause.END_PORTAL) {
		   if(p.getInventory().contains(Material.DIAMOND_CHESTPLATE) || p.getInventory().contains(Material.DIAMOND_LEGGINGS) 
				   || p.getInventory().contains(Material.DIAMOND_BOOTS) 
				   || p.getInventory().contains(Material.DIAMOND_HELMET)) {
			   p.sendMessage("§dDestination Found! §bAt: §a" + DesEnv + " X:" + e.getTo().getBlockX() 
					   + " Y:" + e.getTo().getBlockY() + " Z:" + e.getTo().getBlockZ());
			   p.sendMessage("");
			   e.setCancelled(false);
		   }
		   else {
			    e.setCancelled(true);
				p.sendMessage("§cYou can't use §bEND portals§c until you have a piece of "
						+ "§bDiamond armor §cin your inventory!");
				
		   }
	   	}
   	}
}