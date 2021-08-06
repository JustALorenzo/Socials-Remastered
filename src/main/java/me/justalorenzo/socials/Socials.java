package me.justalorenzo.socials;


import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import me.justalorenzo.socials.commands.CommandHandler;
import me.justalorenzo.socials.commands.ConfigCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

@Singleton
public class Socials extends JavaPlugin {


    public static final String[] COMMAND_LINK_LIST = {"youtube", "facebook", "twitter", "tiktok", "discord", "twitch", "github", "spotify", "steam", "reddit", "instagram", "linktree"};
    public static final String SET_COMMAND = "setlink";
    @Inject
    private ConfigCommands configCommands;
    @Inject
    private CommandHandler commandHandler;

    public void onEnable() {
        this.getLogger().info("Socials Started");
        //fetch dependencies
        SimpleBinderModule injections = new SimpleBinderModule(this);
        Injector injector = injections.createInjector();
        injector.injectMembers(this);


        for (String cmds : COMMAND_LINK_LIST) {
            this.getCommand(cmds).setExecutor(commandHandler);
        }
        this.getCommand(SET_COMMAND).setExecutor(configCommands);
        this.saveDefaultConfig(); //will make config.yml


    }

    public void onDisable() {
        this.getLogger().info("Socials Terminated");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("about")) {
            sender.sendMessage("Lightweight optimized & open source plugin to list your socials!");
            sender.sendMessage("Made by https://github.com/TheRealBeaver");
        }
        return true;
    }
}
