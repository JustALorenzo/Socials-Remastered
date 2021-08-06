package me.justalorenzo.socials;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

//A binding is defined in an implementation of com.google.inject.AbstractModule
public class SimpleBinderModule extends AbstractModule {
    private final Socials plugin;


    // This is also dependency injection, but without any libraries/frameworks since we can't use those here yet.
    // this is also some kind of dependency injection as in we inject plugin in the constructor
    public SimpleBinderModule(Socials plugin) {
        this.plugin = plugin;

    }

    public Injector createInjector() {
        // create Injector object using Guice class createInjector() method where we pass our injector class implementation object
        return Guice.createInjector(this);
    }

    @Override
    protected void configure() {
        //tells the binder to use our plugin instance whenever asked for
        this.bind(Socials.class).toInstance(this.plugin);
    }


}
