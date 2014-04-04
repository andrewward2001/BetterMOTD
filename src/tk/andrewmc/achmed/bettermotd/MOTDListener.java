package tk.andrewmc.achmed.bettermotd;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MOTDListener implements Listener {
	
	public static BetterMOTdMain plugin;
	
	@EventHandler 
	public void onSignCreate(SignChangeEvent sign) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		Player player = sign.getPlayer();
		if(sign.getLine(0).equalsIgnoreCase("[MOTD]")) {
			player.sendMessage("MOTD sign created!");
			sign.setLine(0, ChatColor.DARK_BLUE + "[MOTD]");
		} else if (sign.getLine(0).equalsIgnoreCase("&1[MOTD]")){
			player.sendMessage("MOTD sign created!");
			sign.setLine(0, ChatColor.DARK_BLUE + "[MOTD]");
		}
	}
}
