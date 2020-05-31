package com.redtek.rootsys.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class MarkerBlock extends Block {
  public MarkerBlock(Properties properties) {
    super(properties);
  }

  private static final VoxelShape SHAPE = Block.makeCuboidShape(4D,4D,4D,12D,12D, 12D);

  @Override
  public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
    return SHAPE;
  }
}
