package me.justalorenzo.socials;


import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.getLogger().info("Socials Started");
    }
    public void onDisable() {
        this.getLogger().info("Socials Terminated");
    }

}
