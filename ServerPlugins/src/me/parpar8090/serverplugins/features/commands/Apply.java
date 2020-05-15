/*    */ package me.parpar8090.serverplugins.features.commands;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Apply implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 15 */     if ((sender instanceof Player)) {
/* 16 */       Player p = (Player)sender;
/* 17 */       Location loc = p.getLocation();
/* 18 */       p.sendMessage(ChatColor.BLUE + "§m[-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-]");
/* 19 */       p.sendMessage("§0          §bApply for staff here:");
/* 20 */       p.sendMessage("§b§nhttps://forms.gle/6QvJwFMtH1PBaS9n9");
/* 21 */       p.sendMessage(ChatColor.BLUE + "§m[-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-]");
/* 22 */       p.playSound(loc, Sound.UI_TOAST_CHALLENGE_COMPLETE, 100.0F, 1.0F);
/* 23 */       return true;
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */ }