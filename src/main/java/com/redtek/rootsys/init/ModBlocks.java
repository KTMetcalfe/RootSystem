package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.blocks.EnlightenedChest;
import com.redtek.rootsys.blocks.EnlightenedOre;
import com.redtek.rootsys.blocks.MinerBlock;
import net.minecraft.block.Block;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RootSystem.MODID)
public class ModBlocks {

  public static final Block ENLIGHTENED_ORE = new EnlightenedOre().setRegistryName(RootSystem.MODID,"enlightened_ore");
  public static final Block ENLIGHTENED_CHEST  = new EnlightenedChest().setRegistryName(RootSystem.MODID, "enlightened_chest");
  public static final Block MINERBLOCK = new MinerBlock().setRegistryName(RootSystem.MODID, "minerblock");
}