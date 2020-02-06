package com.redtek.rootsys.items;

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

    BlockPos posTemp = pos;

    Direction up = Direction.UP;
    Direction down = Direction.DOWN;

    Direction right = entityLiving.getHorizontalFacing().rotateY();
    Direction left = right.getOpposite();

    if (entityLiving.rotationPitch > 45 || entityLiving.rotationPitch < -45) {
      up = entityLiving.getHorizontalFacing();
      down = up.getOpposite();
    }

    for (int i = 0; i<8; i++) {

      switch (i) {
        case 0:
          posTemp = pos.offset(up);
          break;
        case 1:
          posTemp = pos.offset(up);
          posTemp = posTemp.offset(right);
          break;
        case 2:
          posTemp = pos.offset(right);
          break;
        case 3:
          posTemp = pos.offset(right);
          posTemp = posTemp.offset(down);
          break;
        case 4:
          posTemp = pos.offset(down);
          break;
        case 5:
          posTemp = pos.offset(down);
          posTemp = posTemp.offset(left);
          break;
        case 6:
          posTemp = pos.offset(left);
          break;
        case 7:
          posTemp = pos.offset(left);
          posTemp = posTemp.offset(up);
          break;
      }

      worldIn.destroyBlock(posTemp, this.canHarvestBlock(worldIn.getBlockState(posTemp)));
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }

  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity entityLiving, Hand handIn) {

    if (!worldIn.isRemote) return null;

    RootSystem.sendMessage(String.valueOf(entityLiving.rotationPitch));
    RootSystem.sendMessage(String.valueOf(entityLiving.getHorizontalFacing()));

    return super.onItemRightClick(worldIn, entityLiving, handIn);
  }
}
