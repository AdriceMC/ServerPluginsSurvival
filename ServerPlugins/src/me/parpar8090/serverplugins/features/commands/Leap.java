package me.parpar8090.serverplugins.features.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Leap implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("leap")){
			if (args.length == 4) {
				String playerName = args[0];
                Player target = sender.getServer().getPlayerExact(playerName);
                if (target == null) { sender.sendMessage("§c" + playerName + " is not online."); }
                else {
                	target.setVelocity(new Vector(Double.valueOf(args[1]), Double.valueOf(args[2]), Double.valueOf(args[3])));
                }
			} else {
				sender.sendMessage("§cUnknown command! Do /leap <player> <x> <y> <z>");
			}
		}
		return true;
	}
	
}
