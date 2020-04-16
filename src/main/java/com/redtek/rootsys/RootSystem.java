package com.redtek.rootsys;

import com.redtek.rootsys.init.*;
import com.redtek.rootsys.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(RootSystem.MODID)
@Mod.EventBusSubscriber(modid = RootSystem.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RootSystem {

  public static final String MODID = "rootsys";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  public static RootSystem instance;

  public RootSystem() {
    LOGGER.debug("Hello World!");

    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.addListener(this::setupCommon);
    modEventBus.addListener(this::setupClient);

    ModItems.ITEMS.register(modEventBus);
    ModBlocks.BLOCKS.register(modEventBus);
    ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    ModContainerTypes.CONTAINER_TYPES.register(modEventBus);

    instance = this;
    MinecraftForge.EVENT_BUS.register(this);
  }

  private void setupCommon(final FMLCommonSetupEvent event) {

  }

  private void setupClient(final FMLClientSetupEvent event) {

  }

  @SubscribeEvent
  public void setupServer(FMLServerStartingEvent event) {

  }

  @SubscribeEvent
  public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    final IForgeRegistry<Item> registry = event.getRegistry();

    ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
      final Item.Properties properties = new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP);
      final BlockItem blockItem = new BlockItem(block, properties);
      blockItem.setRegistryName(block.getRegistryName());
      registry.register(blockItem);
    });

    LOGGER.debug("All registered items: " + registry.getEntries());
  }

//  @SubscribeEvent
//  public static void onRegisterBlocks(final RegistryEvent.Register<Block> event) {
//    final IForgeRegistry<Block> registry = event.getRegistry();
//
//    ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
//      registry.register(block);
//    });
//
//    LOGGER.debug("All registered blocks: " + registry.getEntries());
//  }

  @SubscribeEvent
  public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    OreGeneration.setupOreGeneration();
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
    return setup(entry, new ResourceLocation(MODID, name));
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
    entry.setRegistryName(registryName);
    return entry;
  }
}
