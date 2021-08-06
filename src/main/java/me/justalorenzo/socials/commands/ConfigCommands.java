package me.justalorenzo.socials.commands;

import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;

import org.bukkit.Bukkit;
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


    boolean foundSocials;

    //importing lists of commands, so they're global and, they don't have to be set individually for each update
    String[] commandList = Socials.COMMAND_LINK_LIST;
    String setCommand = Socials.SET_COMMAND;

    //modify config lines
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {


        if (command.getName().equalsIgnoreCase(setCommand)) {
            if (commandSender.hasPermission("socials.set")) {
                if (args.length < 2) {
                    commandSender.sendMessage("You must specify a social platform and link! /set youtube <link> for example!");
                } else {
                    foundSocials = false;
                    for (String cmd : commandList) {
                        if (args[0].equalsIgnoreCase(cmd)) {
                            foundSocials = true;
                            break;
                        }
                    }
                    if (foundSocials) {
                        //go to config & edit it

                            plugin.getConfig().set(args[0], args[1]);
                            plugin.saveConfig();
                        commandSender.sendMessage(ChatColor.GREEN + args[1] + " has been set!");


                    } else {
                        //tell them we couldn't find  args[1]
                        commandSender.sendMessage(ChatColor.BLUE + "We do not support " + args[0] + " as of now, please suggest it if you want it added!");
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
