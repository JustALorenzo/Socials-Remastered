package me.justalorenzo.socials;


import com.google.inject.Injector;
import com.google.inject.Singleton;
import me.justalorenzo.socials.commands.CommandHandler;
import me.justalorenzo.socials.commands.ConfigCommands;
import org.bukkit.plugin.java.JavaPlugin;

@Singleton
public class Socials extends JavaPlugin {


    public static String[] commandLinkList = {"youtube", "facebook", "twitter", "tiktok", "discord", "twitch", "github", "spotify", "steam", "reddit", "instagram"};
    public static String setCommand = "set";

    public void onEnable() {
        this.getLogger().info("Socials Started");
        //fetch dependencies
        SimpleBinderModule injections = new SimpleBinderModule(this, commandLinkList, setCommand);
        Injector injector = injections.createInjector();
        injector.injectMembers(this);


        CommandHandler CH = new CommandHandler();
        ConfigCommands CC = new ConfigCommands(this);
        for (String cmds : commandLinkList) {
            this.getCommand(cmds).setExecutor(CH);
        }
        this.getCommand(setCommand).setExecutor(CC);
        this.saveDefaultConfig();
        Config config = new Config(); //constructor will make config.yml


    }

    public void onDisable() {
        this.getLogger().info("Socials Terminated");
    }

}
