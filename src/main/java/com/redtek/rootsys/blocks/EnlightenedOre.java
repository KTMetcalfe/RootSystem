package com.redtek.rootsys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnlightenedOre extends Block {

  public EnlightenedOre() {
    super(
        Properties.create(Material.IRON)
            .hardnessAndResistance(3.0F, 3.0F)
            .sound(SoundType.METAL)
    );
  }
}