package me.justalorenzo.socials.gui;

import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


import java.util.ArrayList;
import java.util.HashMap;


public class OpenGUI implements CommandExecutor, Listener {

    /*
     * Make sure a player is executing the command!
     * and that the GUI is not returning NULL!
     * */

    private final Socials plugin;
    private CreateGUI GUI = new CreateGUI();
    final String OPENGUI = Socials.SOCIALS_COMMAND;

    @Inject
    public OpenGUI(Socials plugin) {
        this.plugin = plugin;
        createGUI();
    }


    public void createGUI() {
        //set GUI size & title
        GUI.setGUI(54, "Socials");
        //add socials to hashmap starting with name then the base64 code
        HashMap<String, String> name_base64Texture = new HashMap<>();
        name_base64Texture.put("youtube", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJmNmMwN2EzMjZkZWY5ODRlNzJmNzcyZWQ2NDU0NDlmNWVjOTZjNmNhMjU2NDk5YjVkMmI4NGE4ZGNlIn19fQ==");
      name_base64Texture.put("spotify", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmU3OTJkMzhlNDE2OGQyNmRlNzc4Mzk4NGNhZmZmYzYwYjQ4ODM4ZDgxZjIyOTYwNzZmZTE0ZGVkZDYifX19");
        name_base64Texture.put("discord", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19");


        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
        positions.add(i*10);
        }
        GUI.addItem(positions, name_base64Texture);
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
