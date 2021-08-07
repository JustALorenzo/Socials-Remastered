package me.justalorenzo.socials;


import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import me.justalorenzo.socials.commands.CommandHandler;
import me.justalorenzo.socials.commands.ConfigCommands;

import me.justalorenzo.socials.gui.OpenGUI;
import org.bstats.bukkit.Metrics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;


@Singleton
public class Socials extends JavaPlugin {


    public static final String[] COMMAND_LINK_LIST = {"youtube", "facebook", "twitter", "tiktok", "discord", "twitch",
            "github", "spotify", "steam", "reddit", "instagram", "linktree", "patreon", "website"};
    public static final String SET_COMMAND = "setlink";
    public static final String SOCIALS_COMMAND = "socials";

    @Inject
    private ConfigCommands configCommands;
    @Inject
    private CommandHandler commandHandler;
    @Inject
    private OpenGUI openGUI;

    public void onEnable() {
        //fetch dependencies
        SimpleBinderModule injections = new SimpleBinderModule(this);
        Injector injector = injections.createInjector();
        injector.injectMembers(this);

        int pluginId = 12353; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);

        //this.getServer().getPluginManager().registerEvents(heads, this);

        //get our commands and pass them to the right commandExecutor
        initializeCommands();
        this.saveDefaultConfig(); //will make config.yml

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("info")) {
            sender.sendMessage("Lightweight optimized & open source plugin to list your socials!");
            sender.sendMessage("Made by https://github.com/TheRealBeaver");
        }
        return true;
    }


    public void initializeCommands() {
        for (String cmds : COMMAND_LINK_LIST) {
            this.getCommand(cmds).setExecutor(commandHandler);
        }
        this.getCommand(SET_COMMAND).setExecutor(configCommands);
        this.getCommand(SOCIALS_COMMAND).setExecutor(openGUI);
    }


}
