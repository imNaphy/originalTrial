package me.originaltrial;

import me.originaltrial.commands.mobs;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class OriginalTrial extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("mobs").setExecutor(new mobs()); // /mobs
        getServer().getPluginManager().registerEvents(new itemManager(), this);
        itemManager.init(); // Initializarea mobilor + GUI-ului de mobi
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[" + this.getName() + "] Plugin is now enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[" + this.getName() + "] Plugin is now disabled!");
    }
}
