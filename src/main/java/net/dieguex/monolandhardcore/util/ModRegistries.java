package net.dieguex.monolandhardcore.util;

import net.dieguex.monolandhardcore.item.ModItems;
import net.dieguex.monolandhardcore.item.ModItemsGroup;

public class ModRegistries {
    public static void registerMods(){
        registerModItem();
        registerCommandsAndUtils();
    }

    private static void registerCommandsAndUtils() {
        TimeManagerMod.init();
    }

    private static void registerModItem() {
        ModItems.registerModItems();
        ModItemsGroup.registerModItemsGroup();
    }




}
