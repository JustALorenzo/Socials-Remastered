package me.justalorenzo.socials.gui;


import com.google.inject.Inject;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CreateGUI {

    Inventory socialsInventory;
    int GUISize;



    //sets basic GUI information
    public void setGUI(int GUISize, String GUITitle) {
        if (GUISize % 9 != 0) {
            this.GUISize = 9;
            //default it
        } else {
            this.GUISize = GUISize;
        }

        this.socialsInventory = Bukkit.createInventory(null, GUISize, GUITitle);

    }



    public void addItem(ArrayList<Integer> positions, HashMap<String, String> base64Values) {
        //loop through hashmap
        for (String base64 : base64Values.values()) {
            Bukkit.getServer().getLogger().info(base64);
            for(int position : positions) { //not very efficient and quite literally o^2 but easy hotfix to make sure we never go out of bounds
                socialsInventory.setItem(position+1, CustomHeads.create("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJmNmMwN2EzMjZkZWY5ODRlNzJmNzcyZWQ2NDU0NDlmNWVjOTZjNmNhMjU2NDk5YjVkMmI4NGE4ZGNlIn19fQ"));
            socialsInventory.setItem(position+2, CustomHeads.create("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmU3OTJkMzhlNDE2OGQyNmRlNzc4Mzk4NGNhZmZmYzYwYjQ4ODM4ZDgxZjIyOTYwNzZmZTE0ZGVkZDYifX19"));
            socialsInventory.setItem(position+3, CustomHeads.create("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19"));

            }


        }


    }

    public Inventory showGUI() {
        return socialsInventory;
    }


}
