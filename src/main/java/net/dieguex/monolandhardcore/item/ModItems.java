package net.dieguex.monolandhardcore.item;

import net.dieguex.monolandhardcore.MonolandHardcore;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item HYPER_SOUL = registerItem(
            "hyper_soul",
            properties -> new Item(properties.rarity(Rarity.RARE)));



    private static Item registerItem(String name,
                                     Function<Item.Properties, Item> function){
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MonolandHardcore.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MonolandHardcore.MOD_ID, name)))));
    }

    public static void registerModItems(){
        MonolandHardcore.LOGGER.info("Enregistrement des items pour " + MonolandHardcore.MOD_ID);
    }
}
