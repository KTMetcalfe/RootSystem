package com.redtek.rootsys.blocks;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.client.gui.MinerBlockScreen;
import com.redtek.rootsys.init.ModTileEntityTypes;
import com.redtek.rootsys.tileentity.EnlightenedChestTileEntity;
import com.redtek.rootsys.tileentity.MinerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MinerBlock extends Block {

  public MinerBlock(Properties properties) {
    super(properties);
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

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if(!worldIn.isRemote) {
      TileEntity tile = worldIn.getTileEntity(pos);
      if(tile instanceof MinerTileEntity) {
        Minecraft.getInstance().displayGuiScreen(new MinerBlockScreen());
        return ActionResultType.SUCCESS;
      }
    }
    return ActionResultType.FAIL;
  }
}
