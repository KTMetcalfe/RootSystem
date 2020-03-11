package com.redtek.rootsys.blocks;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnlightenedChest extends HorizontalBlock {

  public EnlightenedChest() {
    super(
        Properties.create(Material.IRON)
        .hardnessAndResistance(3.0F, 3.0F)
        .sound(SoundType.ANVIL)
    );
  }
}
