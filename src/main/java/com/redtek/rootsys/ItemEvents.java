package com.redtek.rootsys;

import com.redtek.rootsys.init.ModBlocks;
import com.redtek.rootsys.init.ModItems;
import com.redtek.rootsys.items.TestAxe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemEvents {
  public static void hammerMode(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

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

      if (stack.canHarvestBlock(worldIn.getBlockState(posTemp))) {
        worldIn.destroyBlock(posTemp, true);
      } else if (worldIn.getBlockState(pos).getBlock() == Blocks.OAK_LOG && worldIn.getBlockState(posTemp).getBlock() == Blocks.OAK_LOG && entityLiving.getHeldItemMainhand().getItem() == ModItems.TEST_AXE) {
        worldIn.destroyBlock(posTemp, true);
      }
    }
  }
}
