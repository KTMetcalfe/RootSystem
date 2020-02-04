package com.redtek.rootsys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.IProperty;
import net.minecraft.world.gen.Heightmap;

public class TestOre extends Block {

    public TestOre() {
        super(
                Properties.create(Material.IRON)
                .hardnessAndResistance(3.0F, 3.0F)
                .sound(SoundType.METAL)
        );
    }
}