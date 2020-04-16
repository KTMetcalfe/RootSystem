package com.redtek.rootsys.tileentity;

import com.redtek.rootsys.blocks.MarkerBlock;
import com.redtek.rootsys.blocks.MinerBlock;
import com.redtek.rootsys.init.ModTileEntityTypes;
import com.redtek.rootsys.util.helpers.NBTHelper;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.*;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.extensions.IForgeBlockState;

import javax.annotation.Nullable;

public class MinerTileEntity extends TileEntity implements ITickableTileEntity {

  public int x, y, z, tick;
  boolean initialized = false;

  public MinerTileEntity(final TileEntityType<?> tileEntityTypeIn) {
    super(tileEntityTypeIn);
  }

  public MinerTileEntity() {
    this(ModTileEntityTypes.MINERBLOCK.get());
  }

  @Override
  public void tick() {
    if(!initialized) init();
    tick++;
    if(tick == 20) {
      tick = 0;
      if(y > 4) execute();
    }
  }

  private void init() {
    checkForMarkers(world, pos);
    initialized = true;
    x = startX;
    y = this.pos.getY() - 1;
    z = startZ;
    tick = 0;
  }

  private void execute() {
    if(x <= endX) {
      BlockPos posBreak = new BlockPos(x, y, z);
      destroyBlock(posBreak, true, null);
      x++;
    } else if(x > endX) {
      if (z < endZ) {
        x = startX;
        z++;
      } else if(z >= endZ) {
        x = startX;
        z = startZ;
        y--;
      }
    }
  }

  public boolean destroyBlock(BlockPos posIn, boolean dropBlock, @Nullable Entity entityIn) {
    BlockState state = world.getBlockState(posIn);
    if(state.isAir(world, posIn)) return false;
    else {
      IFluidState ifluidstate = world.getFluidState(posIn);
      world.playEvent(2001, posIn, Block.getStateId(state));
      if(dropBlock) {
        TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(posIn) : null;
        Block.spawnDrops(state, world, this.pos.add(0.0d, 1.5d, 0.0d), tileentity, entityIn, ItemStack.EMPTY);
      }
      return world.setBlockState(posIn, ifluidstate.getBlockState(), 3);
    }
  }

  @Override
  public CompoundNBT write(CompoundNBT compound) {
    compound.put("initvalues", NBTHelper.toNBT(this));
    return super.write(compound);
  }

  @Override
  public void read(CompoundNBT compound) {
    super.read(compound);
    CompoundNBT initvalues = compound.getCompound("initvalues");
    if(initvalues != null) {
      this.x = initvalues.getInt("x");
      this.y = initvalues.getInt("y");
      this.z = initvalues.getInt("z");
      this.tick = 0;
      initialized = true;
      return;
    }
    init();
  }

  int maxX = 32;
  int maxZ = 32;
  int startX, startZ, endX, endZ;

  private void checkForMarkers(World world, BlockPos posMiner) {
    startX = -1;
    startZ = -1;
    endX = 1;
    endZ = 1;
    for(int side = 0; side < 4; side++) {
      Direction direction = Direction.fromAngle(side * 90);
      BlockPos posCheck = posMiner.offset(direction);
      if(world.getBlockState(posCheck).getBlock() instanceof MarkerBlock) {
        for (int x = -maxX; x <= maxX; x++) {
          BlockPos findX = posCheck.add(x, 0, 0);
          for (int z = -maxZ; z <= maxZ; z++) {
            BlockPos findZ = posCheck.add(0, 0, z);
            if(world.getBlockState(findZ).getBlock() instanceof MarkerBlock && findZ != posCheck) {
              startZ = Math.min(posCheck.getZ(), findZ.getZ()) + 1;
              endZ = Math.max(posCheck.getZ(), findZ.getZ()) - 1;
              break;
            }
          }
          if(world.getBlockState(findX).getBlock() instanceof MarkerBlock && findX != posCheck) {
            startX = Math.min(posCheck.getX(), findX.getX()) + 1;
            endX = Math.max(posCheck.getX(), findX.getX()) - 1;
            break;
          }
        }

        break;
      }
    }
  }
}
