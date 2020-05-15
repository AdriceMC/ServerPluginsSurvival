/*    */ package me.parpar8090.serverplugins.features.commands;
/*    */ 
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class TutorialCmd implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 13 */     if ((sender instanceof Player)) {
/* 14 */       Player p = (Player)sender;
/* 15 */       if (cmd.getName().equalsIgnoreCase("tutorial"))
/*    */       {
/* 17 */         if (args.length == 1) {
/* 18 */           if (args[0].equalsIgnoreCase("1")) {
/* 19 */             p.sendMessage("§3-----------§bPage 1 | /tutorial [page number]§3-----------");
/* 20 */             p.sendMessage(ChatColor.DARK_AQUA + "1. If you want to create a protected area");
/* 21 */             p.sendMessage(ChatColor.DARK_AQUA + "from griefers, you should use the §n/rp§3 command.");
/* 22 */             p.sendMessage("");
/* 23 */             p.sendMessage(ChatColor.AQUA + "2. §n/rp wand§b command, will give you an §nIron Horse Armor");
/* 24 */             p.sendMessage(ChatColor.AQUA + "and with it you right and left click to select a box which");
/* 25 */             p.sendMessage(ChatColor.AQUA + "is the protected area dimensions. After that you may do §n/rp define <name your area>");
/* 26 */             p.sendMessage(ChatColor.AQUA + "to confirm your action.");
/* 27 */             p.sendMessage("");
/* 28 */             p.sendMessage(ChatColor.DARK_AQUA + "3. §n/tpa <player>§3 command, will teleport you to someone if they accept");
/*    */           }
/* 30 */           else if (args[0].equalsIgnoreCase("2")) {
/* 31 */             p.sendMessage("§3-----------§bPage 2 | /tutorial [page number]§3-----------");
/* 32 */             p.sendMessage(ChatColor.AQUA + "4. You can do §n/music§b to listen to a music while playing!");
/* 33 */             p.sendMessage("");
/* 34 */             p.sendMessage("§35. You can make your own particle creation with §n/pp");
/* 35 */             p.sendMessage("");
/* 36 */             p.sendMessage("§b6. You can start selling items with §d/sell§b! And buy some with §d/buy§b!");
/* 37 */             p.sendMessage("");
/* 38 */             p.sendMessage("§37. You can have Gadgets! just open the §5/menu§3 and click the §5\"§dGadgets Menu§5\"§3.");
/* 39 */             p.sendMessage("");
/* 40 */             p.sendMessage("§b8. Want a different game? Warp to season's spawn? And many more with §d§n/menu§b or §d§n/hub§b!");
/*    */           }
/*    */         }
/*    */         else {
/* 44 */           p.sendMessage(ChatColor.RED + "Try /tutorial [page number]");
/*    */         }
/*    */       }
/*    */     }
/* 48 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\banies85\Desktop\test minecraft server\plugins\ServerPlugins.jar!\me\parpar8090\serverplugins\features\commands\TutorialCmd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */