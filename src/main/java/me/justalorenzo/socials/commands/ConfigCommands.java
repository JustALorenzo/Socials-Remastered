package me.justalorenzo.socials.commands;

import com.google.inject.Inject;
import me.justalorenzo.socials.Config;
import me.justalorenzo.socials.Socials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Locale;

public class ConfigCommands implements CommandExecutor {

//    @Inject
//   private Socials plugin;
    @Inject
    private String[] commandLinkList;
    @Inject
    private String setCommand;


    boolean foundSocials;

    //temporary before injection fix
    String[] commandList = {"youtube", "facebook", "twitter", "tiktok", "discord", "twitch", "github", "spotify", "steam", "reddit", "instagram"};

    Socials plugin;



    public  ConfigCommands(Socials plugin) {
        this.plugin = plugin;
    }


    //modify config lines
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {



        if (command.getName().equalsIgnoreCase("set")) {

            if (args.length < 2) {
                commandSender.sendMessage("You must specify a social platform and link! /set youtube <link> for example!");
            } else {
                foundSocials = false;
                for (String cmd : commandList) {
                    if (args[0].equalsIgnoreCase(cmd)) {
                        foundSocials = true;
                    }
                }
                if (foundSocials) {
                    //go to config & edit it
                    if(plugin == null) {
                        commandSender.sendMessage("Plugin instance is null...");
                    }
                    else {
                        plugin.getConfig().set(args[0], args[1]);
                        plugin.saveConfig();
                        plugin.getLogger().info("Saved it!");
                    }

                } else {
                    //tell them we couldn't find  args[1]
                    commandSender.sendMessage("We do not support " + args[0] + " as of now, please suggest it if you want it added!");
                }


                return true;
            }
            return true;
        }
        return true;
    }
}
