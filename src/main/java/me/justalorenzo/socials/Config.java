package me.justalorenzo.socials;

import com.google.inject.Inject;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    //save config etc
    @Inject
    private Main plugin;

    public void Config(){
        //whenever loaded
        setup();

    }

    public void setup() {
       plugin.getConfig().options().copyDefaults(true);

    }
}
