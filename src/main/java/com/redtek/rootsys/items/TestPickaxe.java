package com.redtek.rootsys.items;

import com.redtek.rootsys.ItemEvents;
import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class TestPickaxe extends PickaxeItem{

  public TestPickaxe() {
    super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }

  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    ItemEvents.hammerMode(stack, worldIn, state, pos, entityLiving);

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }

  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity entityLiving, Hand handIn) {

    if (!worldIn.isRemote) return null;

    RootSystem.sendMessage(String.valueOf(entityLiving.rotationPitch));
    RootSystem.sendMessage(String.valueOf(entityLiving.getHorizontalFacing()));

    return super.onItemRightClick(worldIn, entityLiving, handIn);
  }
}