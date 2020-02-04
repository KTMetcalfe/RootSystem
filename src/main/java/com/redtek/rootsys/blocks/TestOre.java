package com.redtek.rootsys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TestOre extends Block {

    public TestOre() {
        super(
                Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0F, 3.0F)
                .sound(SoundType.ANVIL)
        );
    }
}
