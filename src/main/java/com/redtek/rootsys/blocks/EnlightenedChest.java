package com.redtek.rootsys.blocks;

import com.redtek.rootsys.init.ModBlocks;
import com.redtek.rootsys.init.ModTileEntityTypes;
import com.redtek.rootsys.tileentity.EnlightenedChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EnlightenedChest extends Block {

  public EnlightenedChest() {
    super(
        Properties.from(ModBlocks.ENLIGHTENED_ORE.get())
    );
  }

  @Override
  public boolean hasTileEntity(BlockState stateIn) {
    return true;
  }

  @Override
  public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    return ModTileEntityTypes.ENLIGHTENED_CHEST.get().create();
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if(!worldIn.isRemote) {
      TileEntity tile = worldIn.getTileEntity(pos);
      if(tile instanceof EnlightenedChestTileEntity) {
        NetworkHooks.openGui((ServerPlayerEntity) player, (EnlightenedChestTileEntity) tile, pos);
        return ActionResultType.SUCCESS;
      }
    }
    return ActionResultType.FAIL;
  }

  @Override
  public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
    if(state.getBlock() != newState.getBlock()) {
      TileEntity te = worldIn.getTileEntity(pos);
      if (te instanceof EnlightenedChestTileEntity) {
        InventoryHelper.dropItems(worldIn, pos, ((EnlightenedChestTileEntity) te).getItems());
      }
    }
  }
}
