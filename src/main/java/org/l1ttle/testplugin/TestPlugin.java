package org.l1ttle.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class TestPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, "Ping! We are enabling");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().log(Level.INFO, "Pong! We are disabling");
    }

    @EventHandler
    void onReload() {
        getLogger().severe("RELOAD DETECTED. Please avoid reloading! Reloading can cause many unexpected bugs.");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("testperm")) {
            if (args.length == 2) {
                Player player = Bukkit.getPlayer(args[0]);
                String playerFriendlyName = player.getName();
                if (player.hasPermission(args[1])) {
                    sender.sendMessage(ChatColor.GREEN + "" + playerFriendlyName + " has permission " + args[1]);
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "" + playerFriendlyName + " does not have permission " + args[1]); }
                    return true;
            }
        }
    return false; }
}
