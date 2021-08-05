package me.justalorenzo.socials;


import com.google.inject.Injector;
import me.justalorenzo.socials.commands.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    CommandHandler commands = new CommandHandler();



    public static String[] commandList = {"Discord"};
    public void onEnable() {
        this.getLogger().info("Socials Started");
        //fetch dependencies
        SimpleBinderModule injectThisClass = new SimpleBinderModule(this);
        Injector injector = injectThisClass.createInjector();
        injector.injectMembers(this);
        this.getCommand("discord").setExecutor(commands);

    }
    public void onDisable() {
        this.getLogger().info("Socials Terminated");
    }

}
