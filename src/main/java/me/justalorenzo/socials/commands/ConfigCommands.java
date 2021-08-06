package me.justalorenzo.socials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigCommands implements CommandExecutor {
    //modify config lines
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(command.getName().equalsIgnoreCase("set")) {
            if(args.length < 2) {
                commandSender.sendMessage("You must specify a social platform and link! /set youtube <link> for example!");
            }
            else {
                commandSender.sendMessage("ok working on it");
            }
            return true;
        }
        return false;
    }
}
