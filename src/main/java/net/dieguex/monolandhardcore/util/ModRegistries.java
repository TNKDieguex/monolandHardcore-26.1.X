package net.dieguex.monolandhardcore.util;

import net.dieguex.monolandhardcore.item.ModItems;
import net.dieguex.monolandhardcore.item.ModItemsGroup;

public class ModRegistries {
    public static void registerMods(){
        registerModItem();
    }

    private static void registerModItem() {
        ModItems.registerModItems();
        ModItemsGroup.registerModItemsGroup();
    }


}
