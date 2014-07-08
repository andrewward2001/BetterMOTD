package tk.andrewmc.achmed.bettermotd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterMOTdMain extends JavaPlugin {

	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		getConfig().options().copyDefaults(true);
		this.saveConfig();
		getCommand("MOTD").setExecutor(this);

		getServer().getPluginManager().registerEvents(new MOTDListener(), this);
	}

	@Override
	public void onDisable() {

	}
	
	public void isServer(String servName) {
		if (servName == null) {
			String serveName = servName;
		} else {
			String serveName = servName;
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("MOTD")) {
<<<<<<< HEAD
			if (sender.hasPermission("bettermotd.use")) {
				if (cmd.getName().equalsIgnoreCase("MOTD")) {
					Player player;
					if (sender instanceof Player) {
						player = (Player) sender;
						player.sendMessage(ChatColor
								.translateAlternateColorCodes('&', this
										.getMOTD(player.getName(), player
												.getWorld().getName())));
					}
				}
=======
			Player player;
			if (sender instanceof Player) {
				player = (Player) sender;
				player.sendMessage(ChatColor.translateAlternateColorCodes(
					'&', this.getMOTD(player.getName(), player.getWorld().getName())));
			} else {
				sender.sendMessage("Console output not supported for worlds");
>>>>>>> e2d9ae461089869aa184bedce1b4a08c08f5d8d6
			}
		}

		return false;
	}
<<<<<<< HEAD

	public String getMOTD(String player, String world) {
		return this.getConfig().getString("MOTD").replace("&p", player)
				.replace("&w", world)
				.replace("&s", this.getConfig().getString("serverName"));
=======
	
	public String getMOTD(String player, String world) {
		return this.getConfig().getString("MOTD")
		.replace("&p", player)
		.replace("&w", world)
		.replace("&s", isServer(getConfig().getString("serverName")));
>>>>>>> e2d9ae461089869aa184bedce1b4a08c08f5d8d6
	}
}
