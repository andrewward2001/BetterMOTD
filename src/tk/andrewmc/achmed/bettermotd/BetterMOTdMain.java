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

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("MOTD")) {
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
			}
		}

		return false;
	}

	public String getMOTD(String player, String world) {
		return this.getConfig().getString("MOTD").replace("&p", player)
				.replace("&w", world)
				.replace("&s", this.getConfig().getString("serverName"));
	}
}
