package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.blocks.TestOre;
import net.minecraft.block.Block;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RootSystem.MODID)
public class ModBlocks {

  public static final Block TEST_ORE = new TestOre().setRegistryName(RootSystem.MODID,"test_ore");
}