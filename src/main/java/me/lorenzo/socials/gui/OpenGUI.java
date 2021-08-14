package me.justalorenzo.socials.gui;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.util.HashMap;


public class OpenGUI implements CommandExecutor {

    /*
     * Make sure a player is executing the command!
     * and that the GUI is not returning NULL!
     * */

    private final Socials plugin;

    final String OPENGUI = Socials.SOCIALS_COMMAND;
    //this is a class call
    private CreateGUI GUI;
    @Inject
    public OpenGUI(Socials plugin) {
        this.plugin = plugin;
        GUI  = new CreateGUI(plugin);
        //function in our class
        createGUI();

    }



    public void createGUI() {
        //set GUI size & title
        GUI.setGUI(54, "Socials");
        //add socials to hashmap starting with name then the base64 code
        HashMap<String, String> temp_map = new HashMap<>();

        temp_map.put(ChatColor.RED + "YouTube", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJmNmMwN2EzMjZkZWY5ODRlNzJmNzcyZWQ2NDU0NDlmNWVjOTZjNmNhMjU2NDk5YjVkMmI4NGE4ZGNlIn19fQ==");
        temp_map.put(ChatColor.DARK_PURPLE + "Twitch", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmYxOGZhNDNkNGQ5Mzc4OTQ4YjU2Yjg1YjUzMTk3OTA3NDExOWMxMjUyMzJlNzE1Y2U0YmQ1Mjc4MGFjNGQ3NiJ9fX0=");
        temp_map.put(ChatColor.BLUE + "Discord", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19");
        temp_map.put(ChatColor.LIGHT_PURPLE + "Instagram", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjViM2YyY2ZhMDczOWM0ZTgyODMxNmYzOWY5MGIwNWJjMWY0ZWQyN2IxZTM1ODg4NTExZjU1OGQ0Njc1In19fQ==");
        temp_map.put(ChatColor.AQUA + "Twitter", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2M3NDVhMDZmNTM3YWVhODA1MDU1NTkxNDllYTE2YmQ0YTg0ZDQ0OTFmMTIyMjY4MThjMzg4MWMwOGU4NjBmYyJ9fX0=");
        temp_map.put(ChatColor.YELLOW + "Patreon", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY5M2I2NmE1OTVmNzhhZjNmNTFmNGVmYTRjMTMzNzViMWI5NThlNmY0YzUwN2E0N2M0ZmU1NjVjYzI3NSJ9fX0=");
        temp_map.put(ChatColor.WHITE + "Website", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjI3NGUxNjA1MjMzNDI1MDkxZjdiMjgzN2E0YmI4ZjRjODA0ZGFjODBkYjllNGY1OTlmNTM1YzAzYWZhYjBmOCJ9fX0=");


        BiMap<String, String> name_base64Texture = HashBiMap.create(temp_map);
        //glass panes
        GUI.fillGUI();
        //custom heads
        GUI.addItem(name_base64Texture);
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase(OPENGUI)) {
            if (!(commandSender instanceof Player)) {
                //console performs command
                commandSender.sendMessage("Only players can perform the GUI action!");
            } else {
                //if it is a player
                Player p = ((Player) commandSender).getPlayer();
                plugin.getLogger().info(p.getName());
                p.openInventory(GUI.showGUI());
            }
        }

        return true;
    }


}
