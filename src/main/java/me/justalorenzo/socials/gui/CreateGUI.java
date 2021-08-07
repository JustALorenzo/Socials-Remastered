package me.justalorenzo.socials.gui;


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
        if(GUISize % 9 != 0) {
            this.GUISize = 9;
            //default it
        } else {
            this.GUISize = GUISize;
        }

        this.socialsInventory = Bukkit.createInventory(null, GUISize, GUITitle);

    }

//    //pass item you want
//    public void itemBuilder(ItemStack material, String itemName, String itemLore, int inventoryPosition) {
//        ItemStack inventoryItem = new ItemStack(material);
//        ItemMeta itemMeta = inventoryItem.getItemMeta();
//        itemMeta.setDisplayName(itemName);
//        itemMeta.setLore(Collections.singletonList(itemLore));
//        inventoryItem.setItemMeta(itemMeta);
//        addItem(inventoryPosition, inventoryItem);
//    }

    //Hashmap of NAME of head | and then | the itemstack itself
    public void addItem(int position, HashMap<String, String> base64Values) {

        for(String base64 : base64Values.values()) {
socialsInventory.setItem(position+2, CustomHeads.create(base64));

        }


    }

    public Inventory showGUI() {
        return socialsInventory;
    }


}
