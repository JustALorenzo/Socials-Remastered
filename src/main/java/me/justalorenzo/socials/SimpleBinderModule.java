package me.justalorenzo.socials;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class SimpleBinderModule extends AbstractModule {
    private final Main plugin;


    // This is also dependency injection, but without any libraries/frameworks since we can't use those here yet.
    // dependency injection as in we inject plugin through Main whenever this is called
    public SimpleBinderModule(Main plugin) {
        this.plugin = plugin;

    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
            //tells the binder to use our plugin instance whenever asked for
        this.bind(Main.class).toInstance(this.plugin);

    }


}
