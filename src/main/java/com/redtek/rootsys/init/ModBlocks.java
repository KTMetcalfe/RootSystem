package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.blocks.EnlightenedChest;
import com.redtek.rootsys.blocks.EnlightenedOre;
import com.redtek.rootsys.blocks.MinerBlock;
import com.redtek.rootsys.items.enlightened.EnlightenedPickaxe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

  public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, RootSystem.MODID);


  public static final RegistryObject<Block> ENLIGHTENED_ORE = BLOCKS.register("enlightened_ore", () -> new EnlightenedOre());
  public static final RegistryObject<Block> ENLIGHTENED_CHEST = BLOCKS.register("enlightened_chest", () -> new EnlightenedChest());
  public static final RegistryObject<Block> MINERBLOCK = BLOCKS.register("minerblock", () -> new MinerBlock());
}