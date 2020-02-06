package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestAxe extends AxeItem {

  public TestAxe() {
    super(Tiers.POO, (int) Tiers.POO.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }

  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    for (int i = 0; i < 6; i++) {
      //Vein Miner
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }
}
