package me.justalorenzo.socials;


import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import me.justalorenzo.socials.commands.CommandHandler;
import me.justalorenzo.socials.commands.ConfigCommands;
import org.bukkit.plugin.java.JavaPlugin;

@Singleton
public class Socials extends JavaPlugin {


    public static final String[] COMMAND_LINK_LIST = {"youtube", "facebook", "twitter", "tiktok", "discord", "twitch", "github", "spotify", "steam", "reddit", "instagram"};
    public static final String SET_COMMAND = "set";
    @Inject private ConfigCommands configCommands;
    public void onEnable() {
        this.getLogger().info("Socials Started");
        //fetch dependencies
        SimpleBinderModule injections = new SimpleBinderModule(this, COMMAND_LINK_LIST, SET_COMMAND);
        Injector injector = injections.createInjector();
        injector.injectMembers(this);


        CommandHandler CH = new CommandHandler(this);

        for (String cmds : COMMAND_LINK_LIST) {
            this.getCommand(cmds).setExecutor(CH);
        }
        this.getCommand(SET_COMMAND).setExecutor(configCommands);
        this.saveDefaultConfig();
        Config config = new Config(); //constructor will make config.yml


    }

    public void onDisable() {
        this.getLogger().info("Socials Terminated");
    }

}
