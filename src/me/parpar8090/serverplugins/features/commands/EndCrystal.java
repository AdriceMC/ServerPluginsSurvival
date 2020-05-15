package me.parpar8090.serverplugins.features.commands;

import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EndCrystal implements CommandExecutor {
   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
     if ((sender instanceof Player)) {
       Player p = (Player)sender;
       if(p.getWorld().getEnvironment() == Environment.THE_END) {
    	   ItemStack crystal = new ItemStack(Material.END_CRYSTAL, 4);
    	   p.getInventory().addItem(crystal);
       }
       else {
    	   p.sendMessage("§cYou must be in §eThe End§c to do this!");
       }
     }
     return true;
   }
 }
