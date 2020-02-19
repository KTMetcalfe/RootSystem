package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.blocks.EnlightenedOre;
import net.minecraft.block.Block;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RootSystem.MODID)
public class ModBlocks {

  public static final Block ENLIGHTENED_ORE = new EnlightenedOre().setRegistryName(RootSystem.MODID,"enlightened_ore");
}