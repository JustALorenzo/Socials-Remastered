package me.justalorenzo.socials.commands;

import com.google.inject.Inject;

import me.justalorenzo.socials.Socials;

import me.justalorenzo.socials.database.DataHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class ConfigCommands implements CommandExecutor {
    private final Socials plugin;


    @Inject
    public ConfigCommands(Socials plugin) {
        this.plugin = plugin;

    }


    //importing lists of commands, so they're global and, they don't have to be set individually for each update
    final String setCommand = Socials.SET_COMMAND;
    final String removeCommand = Socials.REMOVE_COMMAND;

    //modify config lines
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (command.getName().equalsIgnoreCase(setCommand)) {
            if (commandSender.hasPermission("socials.set")) {
                if (args.length < 3) {
                    commandSender.sendMessage("You must specify a social platform, link and a head id! /setlink youtube https://youtube.com/pewdiepie 54 for example!");
                } else {


                    //go to db/config & edit it

                    //server is using mySQL
                    DataHandler dataHandler = new DataHandler();
                    try {
                        dataHandler.insertData(args);
                        commandSender.sendMessage(ChatColor.GREEN + args[0] + " was successfully added!");
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        plugin.getLogger().info("Unable to pass data to database");
                    }


                }

            } else {
                commandSender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                return true;
            }
        }
        if (command.getName().equalsIgnoreCase(removeCommand)) {
            if (commandSender.hasPermission("socials.remove")) {
                if (args.length < 1) {
                    commandSender.sendMessage("You must specify a platform! /removelink youtube for example!");
                } else {
                    DataHandler dataHandler = new DataHandler();
                    try {
                        dataHandler.deleteData(args);
                        commandSender.sendMessage(ChatColor.GREEN + args[0] + " was successfully deleted!");
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                commandSender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                return true;
            }
        }


        return true;
    }
}
