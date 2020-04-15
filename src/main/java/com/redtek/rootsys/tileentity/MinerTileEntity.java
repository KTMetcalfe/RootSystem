package com.redtek.rootsys.tileentity;

import com.redtek.rootsys.init.ModTileEntityTypes;
import com.redtek.rootsys.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.Tags;

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
    if(tick == 40) {
      tick = 0;
      if(y > 2) execute();
    }
  }

  private void init() {
    initialized = true;
    x = this.pos.getX() - 1;
    y = this.pos.getY() - 1;
    z = this.pos.getZ() - 1;
    tick = 0;
  }

  private void execute() {
    int index = 0;
    Block[] blocksRemoved = new Block[9];
    for (int x = 0; x < 3; x++) {
      for (int z = 0; z < 3; z++) {
        BlockPos posBreak = new BlockPos(this.x + x, this.y, this.z + z);
        blocksRemoved[index] = this.world.getBlockState(posBreak).getBlock();
        destroyBlock(posBreak, true, null);
        index++;
      }
    }
    this.y--;
  }

  public boolean destroyBlock(BlockPos posIn, boolean dropBlock, @Nullable Entity entityIn) {
    BlockState state = world.getBlockState(posIn);
    if(state.isAir(world, posIn)) return false;
    else {
      IFluidState ifluidstate = world.getFluidState(posIn);
      world.playEvent(2001, posIn, Block.getStateId(state));
      if(dropBlock) {
        TileEntity tileentity = state.hasTileEntity() ? world.getTileEntity(posIn) : null;
        Block.spawnDrops(state, world, this.pos.add(0, 1.5, 0), tileentity, entityIn, ItemStack.EMPTY);
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
}
