package com.redtek.rootsys.items;

import com.redtek.rootsys.ItemEvents;
import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.ModItems;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class TestAxe extends AxeItem {

  public TestAxe() {
    super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }

  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    if (worldIn.getBlockState(pos).getBlock() == Blocks.ACACIA_LOG
        || worldIn.getBlockState(pos).getBlock() == Blocks.BIRCH_LOG
        || worldIn.getBlockState(pos).getBlock() == Blocks.DARK_OAK_LOG
        || worldIn.getBlockState(pos).getBlock() == Blocks.JUNGLE_LOG
        || worldIn.getBlockState(pos).getBlock() == Blocks.OAK_LOG
        || worldIn.getBlockState(pos).getBlock() == Blocks.SPRUCE_LOG) {
      ItemEvents.veinMine(stack, worldIn, state, pos, entityLiving, 16);
      ItemEvents.blocksDestroyed = 0;
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }
}
