package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.tileentity.MinerTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

  public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, RootSystem.MODID);

  public static final RegistryObject<TileEntityType<MinerTileEntity>> MINERBLOCK = TILE_ENTITY_TYPES.register("minerblock", () -> TileEntityType.Builder.create(MinerTileEntity::new, ModBlocks.MINERBLOCK).build(null));
}
