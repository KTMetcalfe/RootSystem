package com.redtek.rootsys;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemEvents {

  public static void hammerMode(ItemStack stackIn, World worldIn, BlockState stateIn, BlockPos posIn, LivingEntity entityLivingIn) {

    BlockPos posTemp = posIn;

    Direction up = Direction.UP;
    Direction down = Direction.DOWN;

    Direction right = entityLivingIn.getHorizontalFacing().rotateY();
    Direction left = right.getOpposite();

    if (entityLivingIn.rotationPitch > 45 || entityLivingIn.rotationPitch < -45) {
      up = entityLivingIn.getHorizontalFacing();
      down = up.getOpposite();
    }

    for (int i = 0; i<8; i++) {

      switch (i) {
        case 0:
          posTemp = posIn.offset(up);
          break;
        case 1:
          posTemp = posIn.offset(up);
          posTemp = posTemp.offset(right);
          break;
        case 2:
          posTemp = posIn.offset(right);
          break;
        case 3:
          posTemp = posIn.offset(right);
          posTemp = posTemp.offset(down);
          break;
        case 4:
          posTemp = posIn.offset(down);
          break;
        case 5:
          posTemp = posIn.offset(down);
          posTemp = posTemp.offset(left);
          break;
        case 6:
          posTemp = posIn.offset(left);
          break;
        case 7:
          posTemp = posIn.offset(left);
          posTemp = posTemp.offset(up);
          break;
      }

      if (stackIn.canHarvestBlock(worldIn.getBlockState(posIn)) && stackIn.canHarvestBlock(worldIn.getBlockState(posTemp)) && worldIn.getBlockState(posTemp).getBlock() != Blocks.AIR) {
//        worldIn.addEntity(new ItemEntity(worldIn, entityLivingIn.prevPosX, entityLivingIn.prevPosY, entityLivingIn.prevPosZ, new ItemStack(worldIn.getBlockState(posTemp).getBlock())));
        worldIn.destroyBlock(posTemp, true);
//        stackIn.damageItem(1, entityLivingIn, entity -> {
//          entityLivingIn.sendBreakAnimation(entity.getActiveHand());
//        }
//        );
        stackIn.setDamage(stackIn.getDamage()+1);
      }
    }
  }

  public static int blocksDestroyed = 0;

  public static void veinMode(ItemStack stackIn, World worldIn, BlockState stateIn, BlockPos posIn, LivingEntity entityLivingIn, int maxBlocksIn) {

    BlockPos posTemp = posIn;

    List<BlockPos> posList = new ArrayList<>();

    for (int i = 0; i < 26; i++) {

      if (blocksDestroyed < maxBlocksIn) {

        switch (i) {
          case 0:
            posTemp = posIn.up();
            break;
          case 1:
            posTemp = posIn.up();
            posTemp = posTemp.north();
            break;
          case 2:
            posTemp = posIn.up();
            posTemp = posTemp.north();
            posTemp = posTemp.east();
            break;
          case 3:
            posTemp = posIn.up();
            posTemp = posTemp.east();
            break;
          case 4:
            posTemp = posIn.up();
            posTemp = posTemp.east();
            posTemp = posTemp.south();
            break;
          case 5:
            posTemp = posIn.up();
            posTemp = posTemp.south();
            break;
          case 6:
            posTemp = posIn.up();
            posTemp = posTemp.south();
            posTemp= posTemp.west();
            break;
          case 7:
            posTemp = posIn.up();
            posTemp = posTemp.west();
            break;
          case 8:
            posTemp = posIn.up();
            posTemp = posTemp.west();
            posTemp = posTemp.north();
            break;
          case 9:
            posTemp = posIn.north();
            break;
          case 10:
            posTemp = posIn.north();
            posTemp = posTemp.east();
            break;
          case 11:
            posTemp = posIn.east();
            break;
          case 12:
            posTemp = posIn.east();
            posTemp = posTemp.south();
            break;
          case 13:
            posTemp = posIn.south();
            break;
          case 14:
            posTemp = posIn.south();
            posTemp= posTemp.west();
            break;
          case 15:
            posTemp = posIn.west();
            break;
          case 16:
            posTemp = posIn.west();
            posTemp = posTemp.north();
            break;
          case 17:
            posTemp = posIn.down();
            break;
          case 18:
            posTemp = posIn.down();
            posTemp = posTemp.north();
            break;
          case 19:
            posTemp = posIn.down();
            posTemp = posTemp.north();
            posTemp = posTemp.east();
            break;
          case 20:
            posTemp = posIn.down();
            posTemp = posTemp.east();
            break;
          case 21:
            posTemp = posIn.down();
            posTemp = posTemp.east();
            posTemp = posTemp.south();
            break;
          case 22:
            posTemp = posIn.down();
            posTemp = posTemp.south();
            break;
          case 23:
            posTemp = posIn.down();
            posTemp = posTemp.south();
            posTemp= posTemp.west();
            break;
          case 24:
            posTemp = posIn.down();
            posTemp = posTemp.west();
            break;
          case 25:
            posTemp = posIn.down();
            posTemp = posTemp.west();
            posTemp = posTemp.north();
            break;
        }

        if (worldIn.getBlockState(posTemp).getBlock() == stateIn.getBlock()) {

//          worldIn.addEntity(new ItemEntity(worldIn, entityLivingIn.prevPosX, entityLivingIn.prevPosY, entityLivingIn.prevPosZ, new ItemStack(worldIn.getBlockState(posTemp).getBlock())));
          worldIn.destroyBlock(posTemp, true);

//          stackIn.damageItem(1, entityLivingIn, entity -> {
//                entityLivingIn.sendBreakAnimation(entity.getActiveHand());
//              });
          stackIn.setDamage(stackIn.getDamage()+1);

          blocksDestroyed++;

          posList.add(posTemp);
        }
      }
    }

    for (BlockPos breakPos:posList) {
      veinMode(stackIn, worldIn, stateIn, breakPos, entityLivingIn, maxBlocksIn);
    }
  }
}
