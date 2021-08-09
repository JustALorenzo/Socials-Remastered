package me.justalorenzo.socials.gui;


import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.inventory.Inventory;


public class InventoryClick implements Listener {

    @Inject
    private Socials plugin;

    String[] commands = Socials.COMMAND_LINK_LIST;
    String linktreeText = ChatColor.WHITE + "Linktree";
    public InventoryClick(Socials plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void clickInventory(InventoryClickEvent e) {

        Inventory inv = e.getInventory();
        //best fix available (casting) to keep it compatible since  1.14+ does not support inv.getInventory.getName()
        //InventoryView inv = (InventoryView) e.getInventory();

        if (inv == null || e.getCurrentItem() == null) {//|| !(e.getCurrentItem().hasItemMeta())
            //invalid event/inventory or didn't click an item

            return;
        } else {
            if (!(e.getCurrentItem().hasItemMeta())) {
                //player clicked something with no CUSTOM meta.
                return;
            }
            if (inv.getItem(34) == null) {
                return;
            }
            //this will always fire IF it is this plugin's
            else if (inv.getItem(34).getItemMeta().getDisplayName().equalsIgnoreCase(linktreeText)) {
                if (e.getCurrentItem().getType() == Material.SKULL_ITEM) { //IF THEY CLICK A HEAD

                    String commandName = e.getCurrentItem().getItemMeta().getDisplayName();
                    commandName = ChatColor.stripColor(commandName);

                    for (String cmd : commands) {
                        if (cmd.equalsIgnoreCase(commandName)) {
                            Player p = (Player) e.getWhoClicked();
                            p.performCommand(commandName);
                        }
                    }
                    e.setCancelled(true);
                } else if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                    e.setCancelled(true);
                }

                e.setCancelled(true);


            } else {
                return;
            }
        }

    }
}

