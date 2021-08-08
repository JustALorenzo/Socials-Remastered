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
import org.bukkit.inventory.InventoryView;

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
        //best fix available (casting) to keep it compatible since  1.14+ does not support inv.getInventory.getName()
        //InventoryView inv = (InventoryView) e.getInventory();

        if ( e == null ||inv == null || e.getCurrentItem().getType() == null || !(e.getCurrentItem().hasItemMeta())) {
            //invalid event/inventory or didn't click an item

        } else {
            String linktreeTitle = e.getCurrentItem().getItemMeta().getDisplayName();
            if(inv.getItem(34).getItemMeta().getDisplayName().equalsIgnoreCase("linktree")) {
            //this will always fire IF it is this plugin's
                String commandName = e.getCurrentItem().getItemMeta().getDisplayName();
                commandName = ChatColor.stripColor(commandName);

                for (String cmd : commands) {
                    if (cmd.equalsIgnoreCase(commandName)) {
                        Player p = (Player) e.getWhoClicked();
                        p.performCommand(commandName);
                    }
                }


                e.setCancelled(true);


            }
            //this ONLY works in 1.8.8
//           else if (inv.getTitle().equalsIgnoreCase("Socials")) {
//                String commandName = e.getCurrentItem().getItemMeta().getDisplayName();
//                commandName = ChatColor.stripColor(commandName);
//
//                for (String cmd : commands) {
//                    if (cmd.equalsIgnoreCase(commandName)) {
//                        Player p = (Player) e.getWhoClicked();
//                        p.performCommand(commandName);
//                    }
//                }
//
//
//                e.setCancelled(true);
//            }
          else {
                return;
            }
        }

    }
}

