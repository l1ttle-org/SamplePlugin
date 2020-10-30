package org.l1ttle.testplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class testperm extends Command {

    protected testperm(String name) {
        super(name);
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        
        if (sender.hasPermission(Arrays.toString(args))) {
            sender.sendMessage("You have permission " + Arrays.toString(args));
            return true; }

        else {
            sender.sendMessage("You do not have permission " + Arrays.toString(args));
            return false; }
        }
    }
