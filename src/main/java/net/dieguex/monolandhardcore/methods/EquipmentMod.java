package net.dieguex.monolandhardcore.methods;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class EquipmentMod {
    public static void equipArmor(Mob mob, List<ItemStack> armorPieces){
        mob.setItemSlot(EquipmentSlot.HEAD, armorPieces.get(0));
        mob.setItemSlot(EquipmentSlot.CHEST, armorPieces.get(1));
        mob.setItemSlot(EquipmentSlot.LEGS, armorPieces.get(2));
        mob.setItemSlot(EquipmentSlot.FEET, armorPieces.get(3));
        preventItemDrops(mob);
    }

    private static void preventItemDrops(Mob mob){
        for (EquipmentSlot slot : EquipmentSlot.values()){
            mob.setDropChance(slot, 0.0f);
        }
    }
}
