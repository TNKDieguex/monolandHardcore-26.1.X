package net.dieguex.monolandhardcore.item;

import net.dieguex.monolandhardcore.MonolandHardcore;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemsGroup {
    public static final ResourceKey<CreativeModeTab> MONOLAND_HARDCORE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(MonolandHardcore.MOD_ID, "monoland_hardcore_tab")
    );

    public static final CreativeModeTab CREATIVE_MODE_TAB = FabricCreativeModeTab.builder()
            .icon(()-> new ItemStack(ModItems.HYPER_SOUL))
            .title(Component.translatable("itemGroup.monoland_hardcore_tab"))
            .displayItems((params, output) -> {
                output.accept(ModItems.HYPER_SOUL);
            })
            .build();

    public static void registerModItemsGroup(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MONOLAND_HARDCORE_TAB_KEY, CREATIVE_MODE_TAB);
        MonolandHardcore.LOGGER.info("Enregistrement des groupes d'items pour " + MonolandHardcore.MOD_ID);
    }
}
