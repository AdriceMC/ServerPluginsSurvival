package me.parpar8090.serverplugins.features;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Interactions implements Listener, InventoryHolder, CommandExecutor{
	private final Inventory inv;
	//private Player clicked;
	
	public void onInteract(PlayerInteractEntityEvent e) {
		if(e.getRightClicked() instanceof Villager) {
			e.getPlayer().sendMessage("§dWanna trade?");
		}
		if(e.getRightClicked() instanceof Player) {
			Player p = e.getPlayer();
			//this.clicked = (Player) e.getRightClicked();
			p.openInventory(inv);
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			openInventory((Player) sender);
		}
		return true;
	}

    public Interactions() {
        inv = Bukkit.createInventory(this, 3*9, "Info");
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

   //public void initializeItems() {
   //    inv.setItem(arg0, arg1);
   //}

    // You can open the inventory with this
   public void openInventory(Player p) {
       p.openInventory(inv);
       inv.setItem(14, setSkull(p));
   }

    // Check for clicks on items
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
       if (e.getInventory().equals(inv)) {
    	   if (e.getInventory().getHolder() != this) {
               return;
           }
    	   	e.setCancelled(true);

       		ItemStack clickedItem = e.getCurrentItem();

       		if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
       }
   }
    public ItemStack setSkull(Player p) {
    	ItemStack item = new ItemStack(Material.PLAYER_HEAD);
    	SkullMeta skull = (SkullMeta) item.getItemMeta();
    	skull.setOwningPlayer(p.getPlayer());
    	skull.setDisplayName("§c" + p.getDisplayName() + "\'s Stats:");
    	ArrayList<String> lore = new ArrayList<String>();
        lore.add("§cHealth: " + p.getHealth() + " HP");
        lore.add("§3XP Level: " + p.getLevel());
        lore.add("§2Hunger: " + p.getFoodLevel());
        lore.add("§aTotal played time (In minutes): " + p.getStatistic(Statistic.PLAY_ONE_MINUTE));
        lore.add("§aTotal walk distance: " + p.getStatistic(Statistic.WALK_ONE_CM));
        skull.setLore(lore);
        item.setItemMeta(skull);
        
    	return item;
    }
    
    public void setHead(Player p) {
    	if(p.getInventory().getHelmet() != null) {
    		inv.setItem(12, p.getInventory().getHelmet());
    	} else {
    		ItemStack item = new ItemStack(Material.BARRIER);
        	ItemMeta meta = item.getItemMeta();
        	meta.setDisplayName("§cNo helmet!");
        	item.setItemMeta(meta);
    		inv.setItem(12, item);
    	}
    }
    public void setBody(Player p) {
    	if(p.getInventory().getHelmet() != null) {
    		inv.setItem(13, p.getInventory().getChestplate());
    	} else {
    		ItemStack item = new ItemStack(Material.BARRIER);
        	ItemMeta meta = item.getItemMeta();
        	meta.setDisplayName("§cNo chestplate!");
        	item.setItemMeta(meta);
    		inv.setItem(13, item);
    	}
    }
    public void setLegs(Player p) {
    	if(p.getInventory().getHelmet() != null) {
    		inv.setItem(14, p.getInventory().getLeggings());
    	} else {
    		ItemStack item = new ItemStack(Material.BARRIER);
        	ItemMeta meta = item.getItemMeta();
        	meta.setDisplayName("§cNo leggings!");
        	item.setItemMeta(meta);
    		inv.setItem(14, item);
    	}
    }
    public void setBoots(Player p) {
    	if(p.getInventory().getHelmet() != null) {
    		inv.setItem(15, p.getInventory().getBoots());
    	} else {
    		ItemStack item = new ItemStack(Material.BARRIER);
        	ItemMeta meta = item.getItemMeta();
        	meta.setDisplayName("§cNo boots!");
        	item.setItemMeta(meta);
    		inv.setItem(15, item);
    	}
    }
    public void setSlot(Player p) {
    	if(p.getInventory().getHelmet() != null) {
    		inv.setItem(10, p.getInventory().getItemInMainHand());
    	} else {
    		ItemStack item = new ItemStack(Material.BARRIER);
        	ItemMeta meta = item.getItemMeta();
        	meta.setDisplayName("§cNo main-hand item selected!");
        	item.setItemMeta(meta);
    		inv.setItem(10, item);
    	}
    }
    public void setOffSlot(Player p) {
    	if(p.getInventory().getHelmet() != null) {
    		inv.setItem(11, p.getInventory().getItemInOffHand());
    	} else {
    		ItemStack item = new ItemStack(Material.BARRIER);
        	ItemMeta meta = item.getItemMeta();
        	meta.setDisplayName("§cNo off-hand item selected!");
        	item.setItemMeta(meta);
    		inv.setItem(11, item);
    	}
    }

}
