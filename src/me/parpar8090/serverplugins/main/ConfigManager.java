package me.parpar8090.serverplugins.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class ConfigManager
{
	ServerPlugins p;
  
  private File ff;
  
  public ConfigManager(ServerPlugins p) { this.p = p; }

  
  private FileConfiguration friends;


public void setup(Plugin p) {
    if (!p.getDataFolder().exists()) {
      p.getDataFolder().mkdir();
    }
    
    this.ff = new File(p.getDataFolder(), "friends.yml");
    
    if (!this.ff.exists()) {
      p.saveResource("friends.yml", false);
      Bukkit.getConsoleSender().sendMessage("§aSuccesfully Created friends.yml!");
    } 
 
    this.friends = YamlConfiguration.loadConfiguration(this.ff);

  }

  
  public FileConfiguration getFriendConfig() { return this.friends; }



  public void saveFriendConfig() {
    try {
      this.friends.save(this.ff);
    } catch (IOException e) {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save friends.yml!");
    } 
  }

  
  public void reloadFriendConfig() {
    this.friends = YamlConfiguration.loadConfiguration(this.ff);
    
    this.ff = new File(this.p.getDataFolder(), "friends.yml");
    
    if (!this.ff.exists()) {
      this.p.saveResource("friends.yml", false);
      Bukkit.getConsoleSender().sendMessage("§aSuccesfully Created friends.yml!");
    } 
  }


  
  
  public void checkData(Player player) {
        String pname = player.getUniqueId().toString();
        String name = player.getName().toString();
        
        if(this.getFriendConfig().contains("Players." + pname) == true) {
	    	getFriendConfig().set("Players." + pname + ".Name", name);
	    }
        else {
        	getFriendConfig().set("Players.", pname);
        }
    }
}
