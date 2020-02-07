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
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

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

      if (stack.canHarvestBlock(worldIn.getBlockState(pos)) && stack.canHarvestBlock(worldIn.getBlockState(posTemp)) && worldIn.getBlockState(posTemp).getBlock() != Blocks.AIR) {
        worldIn.destroyBlock(posTemp, true);
        stack.damageItem(1, entityLiving, entity -> {
          entityLiving.sendBreakAnimation(entity.getActiveHand());
        }
        );
      }
    }
  }

  public static int blocksDestroyed = 0;

  public static void veinMine(ItemStack stackIn, World worldIn, BlockState stateIn, BlockPos posIn, LivingEntity entityLivingIn, int maxBlocksIn) {

    BlockPos posTemp = posIn;

    List<BlockPos> posList = new ArrayList<>();

    for (int i = 0; i < 6; i++) {

      if (blocksDestroyed < maxBlocksIn) {

        switch (i) {
          case 0:
            posTemp = posIn.up();
            break;
          case 1:
            posTemp = posIn.down();
            break;
          case 2:
            posTemp = posIn.north();
            break;
          case 3:
            posTemp = posIn.south();
            break;
          case 4:
            posTemp = posIn.east();
            break;
          case 5:
            posTemp = posIn.west();
            break;
        }

        if (worldIn.getBlockState(posTemp).getBlock() == Blocks.ACACIA_LOG
            || worldIn.getBlockState(posTemp).getBlock() == Blocks.BIRCH_LOG
            || worldIn.getBlockState(posTemp).getBlock() == Blocks.DARK_OAK_LOG
            || worldIn.getBlockState(posTemp).getBlock() == Blocks.JUNGLE_LOG
            || worldIn.getBlockState(posTemp).getBlock() == Blocks.OAK_LOG
            || worldIn.getBlockState(posTemp).getBlock() == Blocks.SPRUCE_LOG) {

          worldIn.destroyBlock(posTemp, true);

          stackIn.damageItem(1, entityLivingIn, entity -> {
                entityLivingIn.sendBreakAnimation(entity.getActiveHand());
              });

          blocksDestroyed++;

          posList.add(posTemp);
        }
      }
    }

    for (BlockPos breakPos:posList) {
      veinMine(stackIn, worldIn, stateIn, breakPos, entityLivingIn, maxBlocksIn);
    }
  }
}
