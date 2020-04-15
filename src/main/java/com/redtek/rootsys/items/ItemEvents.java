package com.redtek.rootsys.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.StringNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ItemEvents {

  public static boolean destroyBlock(World world, BlockPos posIn, boolean dropBlock, @Nullable Entity entityIn, ItemStack stackIn) {
    BlockState state = world.getBlockState(posIn);
    if(state.isAir(world, posIn)) return false;
    else {
      IFluidState ifluidstate = world.getFluidState(posIn);
      world.playEvent(2001, posIn, Block.getStateId(state));
      if(dropBlock) {
        TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(posIn) : null;
        Block.spawnDrops(state, world, posIn, tileentity, entityIn, stackIn);
      }
      return world.setBlockState(posIn, ifluidstate.getBlockState(), 3);
    }
  }

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

      if (stackIn.canHarvestBlock(worldIn.getBlockState(posIn))
          && stackIn.canHarvestBlock(worldIn.getBlockState(posTemp))
          && worldIn.getBlockState(posTemp).getBlock() != Blocks.AIR) {

        if(destroyBlock(worldIn, posTemp, true, entityLivingIn, stackIn)) {
          stackIn.setDamage(stackIn.getDamage() + 1);
        }
      }
    }
  }

  // This mode will mine all similar connected blocks up to 32 destroyed

  public static int blocksDestroyed = 0;

  public static void veinMode(ItemStack stackIn, World worldIn, BlockState stateIn, BlockPos posIn, LivingEntity entityLivingIn, double maxBlocksIn, BlockPos posOg) {

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


        //TODO Make this destroy area from og block not a random direction -- queue system??
        if (worldIn.getBlockState(posTemp).getBlock() == stateIn.getBlock()) {

          if(destroyBlock(worldIn, posTemp, true, entityLivingIn, stackIn)) {
            stackIn.setDamage(stackIn.getDamage() + 1);
          }

          blocksDestroyed++;

          posList.add(posTemp);
        }
      }
    }

    for (BlockPos breakPos:posList) {
      veinMode(stackIn, worldIn, stateIn, breakPos, entityLivingIn, maxBlocksIn, posOg);
//      entityLivingIn.sendMessage(new TranslationTextComponent(posList.toString()));
    }
  }
}
