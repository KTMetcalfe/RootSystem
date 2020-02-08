package com.redtek.rootsys.items;

import com.redtek.rootsys.ItemEvents;
import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestAxe extends AxeItem {

  public TestAxe() {
    super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }

  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    if (worldIn.getBlockState(pos).getBlock().getRegistryName().toString().contains("ore")) {
      ItemEvents.veinMode(stack, worldIn, state, pos, entityLiving, 32);
      ItemEvents.blocksDestroyed = 0;
    } else {
      ItemEvents.hammerMode(stack, worldIn, state, pos, entityLiving);
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }
}
