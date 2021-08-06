package me.justalorenzo.socials.commands;

import com.google.inject.Inject;
import me.justalorenzo.socials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigCommands implements CommandExecutor {

    @Inject
    private Main plugin;

    boolean foundSocials;

    //modify config lines
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        String[] commands = Main.commandLinkList;
        if (command.getName().equalsIgnoreCase("set")) {

            if (args.length < 2) {
                commandSender.sendMessage("You must specify a social platform and link! /set youtube <link> for example!");
            } else {
                foundSocials = false;
                for (String cmd : commands) {
                    if (command.getName().equalsIgnoreCase(cmd)) {
                        foundSocials = true;
                    }
                }
                if (foundSocials) {
                    //go to config & edit it
                } else {
                    //tell them we couldn't find  args[1]
                }



            }
            return true;
        }
        return false;
    }
}
