package me.justalorenzo.socials.gui;


import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class InventoryClick implements Listener {

    @Inject
    private Socials plugin;

String[] commands = Socials.COMMAND_LINK_LIST;


    public InventoryClick(Socials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent e) {

        Inventory inv = e.getInventory();
        if(inv.getName().equalsIgnoreCase("Socials")) {
          String commandName = e.getCurrentItem().getItemMeta().getDisplayName();
          commandName = ChatColor.stripColor(commandName);

          for(String cmd : commands) {
              if(cmd.equalsIgnoreCase(commandName)) {
                  Player p = (Player) e.getWhoClicked();
                  p.performCommand( commandName);
              }
          }


        e.setCancelled(true);
        }
        else {
            return;
        }
    }
}
