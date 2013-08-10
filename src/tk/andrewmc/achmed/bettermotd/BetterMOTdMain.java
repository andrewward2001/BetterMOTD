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
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("MOTD")) {
			Player player = (Player) sender;
			sender.sendMessage(""
					+ getConfig().getString("MOTD")
							.replace("&p", sender.getName())
							.replace("&w", player.getWorld().getName())
							.replace("&s", getConfig().getString("serverName"))
							.replaceAll("&r", ChatColor.RESET + "")
							.replaceAll("&4", ChatColor.DARK_RED + "")
							.replaceAll("&c", ChatColor.RED + "")
							.replaceAll("&6", ChatColor.GOLD + "")
							.replaceAll("&e", ChatColor.YELLOW + "")
							.replaceAll("&2", ChatColor.DARK_GREEN + "")
							.replaceAll("&a", ChatColor.GREEN + "")
							.replaceAll("&b", ChatColor.AQUA + "")
							.replaceAll("&3", ChatColor.DARK_AQUA + "")
							.replaceAll("&1", ChatColor.DARK_BLUE + "")
							.replaceAll("&9", ChatColor.BLUE + "")
							.replaceAll("&d", ChatColor.LIGHT_PURPLE + "")
							.replaceAll("&5", ChatColor.DARK_PURPLE + "")
							.replaceAll("&f", ChatColor.WHITE + "")
							.replaceAll("&7", ChatColor.GRAY + "")
							.replaceAll("&8", ChatColor.DARK_GRAY + "")
							.replaceAll("&0", ChatColor.BLACK + "")
							.replaceAll("&l", ChatColor.BOLD + "")
							.replaceAll("&n", ChatColor.UNDERLINE + "")
							.replaceAll("&o", ChatColor.ITALIC + "")
							.replaceAll("&k", ChatColor.MAGIC + "")
							.replaceAll("&m", ChatColor.STRIKETHROUGH + ""));
		}
		return false;
	}
}
