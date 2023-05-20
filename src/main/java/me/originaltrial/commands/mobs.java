package me.originaltrial.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.originaltrial.itemManager.mobGUI;
import static org.bukkit.Bukkit.getServer;

public class mobs implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Doar jucatorii pot folosi aceasta comanda!");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("mobs")) {
            ((Player) sender).openInventory(mobGUI);
            return true;
        }
        return true;
    }
}
