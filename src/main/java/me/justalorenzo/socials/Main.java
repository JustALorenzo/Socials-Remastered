package me.justalorenzo.socials;


import com.google.inject.Injector;
import me.justalorenzo.socials.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    CommandHandler commands = new CommandHandler();



    public static String[] commandList = {"youtube", "facebook", "twitter", "tiktok", "discord", "twitch", "github", "spotify", "steam", "reddit", "instagram"};
    public void onEnable() {
        this.getLogger().info("Socials Started");
        //fetch dependencies
        SimpleBinderModule injectThisClass = new SimpleBinderModule(this);
        Injector injector = injectThisClass.createInjector();
        injector.injectMembers(this);

        CommandHandler CH = new CommandHandler();

        for(String cmds : commandList){
        this.getCommand(cmds).setExecutor(CH);
        }
        this.saveDefaultConfig();
        Config config = new Config(); //constructor will make config.yml


    }
    public void onDisable() {
        this.getLogger().info("Socials Terminated");
    }

}
