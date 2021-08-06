package me.justalorenzo.socials;

import com.google.inject.Inject;


public class Config {
    //save config etc
    @Inject
    private Socials plugin;

    public void Config(){
        //whenever loaded
        setup();

    }

    public void setup() {

       plugin.getConfig().options().copyDefaults(true);

    }
}
