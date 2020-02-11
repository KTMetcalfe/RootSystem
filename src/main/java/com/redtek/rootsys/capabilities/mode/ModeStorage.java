package com.redtek.rootsys.capabilities.mode;

import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class ModeStorage implements Capability.IStorage<IMode> {

  CompoundNBT nbtTag = new CompoundNBT();

  @Nullable
  @Override
  public INBT writeNBT(Capability<IMode> capability, IMode instance, Direction side) {
    nbtTag.putString("Mode", instance.getMode());
    return nbtTag;
  }

  @Override
  public void readNBT(Capability<IMode> capability, IMode instance, Direction side, INBT nbt) {
    instance.setMode(((CompoundNBT) nbt).getString("Mode"));
  }
}