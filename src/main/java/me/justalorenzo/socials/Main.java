package me.justalorenzo.socials;


import com.google.inject.Injector;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.getLogger().info("Socials Started");

        SimpleBinderModule injectThisClass = new SimpleBinderModule(this);
        Injector injector = injectThisClass.createInjector();
        injector.injectMembers(this);


    }
    public void onDisable() {
        this.getLogger().info("Socials Terminated");
    }

}
