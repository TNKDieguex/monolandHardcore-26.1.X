package net.dieguex.monolandhardcore.mixin;

import net.dieguex.monolandhardcore.methods.EquipmentMod;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.zombie.Drowned;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Mob.class)
public class ZombieEntityMixin {

	@Inject(method = "finalizeSpawn", at = @At("TAIL"))
	private void onInitialize(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason,
							  SpawnGroupData groupData, CallbackInfoReturnable<SpawnGroupData> cir) {
		Mob mob = (Mob) (Object) this;
		if (mob instanceof Zombie zombie && !(mob instanceof Drowned)){
			EquipmentMod.equipArmor(zombie, List.of(
					new ItemStack(Items.GOLDEN_HELMET),
					new ItemStack(Items.GOLDEN_CHESTPLATE),
					new ItemStack(Items.GOLDEN_LEGGINGS),
					new ItemStack(Items.GOLDEN_BOOTS)
			));
			mob.setItemInHand(InteractionHand.MAIN_HAND,new ItemStack(Items.GOLDEN_AXE));
		}
	}
}