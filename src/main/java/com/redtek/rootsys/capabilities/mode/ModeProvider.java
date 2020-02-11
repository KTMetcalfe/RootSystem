package com.redtek.rootsys.capabilities.mode;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ModeProvider implements ICapabilitySerializable<INBT> {
  @CapabilityInject(IMode.class)
  public static final Capability<IMode> MODE_CAP = null;

  private IMode instance = MODE_CAP.getDefaultInstance();

  @Nonnull
  @Override
  public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
  }

  @Override
  public INBT serializeNBT() {
    return null;
  }

  @Override
  public void deserializeNBT(INBT nbt) {

  }
}
