package com.redtek.rootsys.blocks;

import com.redtek.rootsys.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class MinerBlock extends Block {

  public MinerBlock() {
    super(
            Block.Properties.create(Material.IRON)
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    );
  }

  @Override
  public boolean hasTileEntity(BlockState state) {
    return true;
  }

  @Nullable
  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return ModTileEntityTypes.MINERBLOCK.get().create();
  }
}
