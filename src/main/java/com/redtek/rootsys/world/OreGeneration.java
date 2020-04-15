package com.redtek.rootsys.world;

import com.redtek.rootsys.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
  public static void setupOreGeneration() {
    for (Biome biome : ForgeRegistries.BIOMES) {
      ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 5, 5, 25));

      biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.ENLIGHTENED_ORE.getDefaultState(), 5)).withPlacement(customConfig));
    }
  }
}
