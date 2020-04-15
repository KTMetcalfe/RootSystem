package com.redtek.rootsys;

import com.redtek.rootsys.init.ModBlocks;
import com.redtek.rootsys.init.ModItemGroup;
import com.redtek.rootsys.init.ModItems;
import com.redtek.rootsys.init.ModTileEntityTypes;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
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

    ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);

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
  public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {

    final Block[] blocks = {
            ModBlocks.ENLIGHTENED_ORE,
            ModBlocks.ENLIGHTENED_CHEST,
            ModBlocks.MINERBLOCK
    };

    event.getRegistry().registerAll(blocks);

    RootSystem.LOGGER.debug("All registered blocks: " + ForgeRegistries.BLOCKS.getEntries());

  }

  @SubscribeEvent
  public static void onRegisterItems(RegistryEvent.Register<Item> event) {

    final Item[] items = {
        ModItems.ENLIGHTENED_PICKAXE,
        ModItems.ENLIGHTENED_AXE,
        ModItems.ENLIGHTENED_HELMET,
        ModItems.ENLIGHTENED_CHESTPLATE,
        ModItems.ENLIGHTENED_LEGGINGS,
        ModItems.ENLIGHTENED_BOOTS,
        ModItems.ENLIGHTENED_SHARD
    };

    final Item[] itemblocks = {
            new BlockItem(ModBlocks.ENLIGHTENED_ORE, new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP)).setRegistryName(RootSystem.MODID, "enlightened_ore"),
            new BlockItem(ModBlocks.ENLIGHTENED_CHEST, new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP)).setRegistryName(RootSystem.MODID, "enlightened_chest"),
            new BlockItem(ModBlocks.MINERBLOCK, new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP)).setRegistryName(RootSystem.MODID, "minerblock")
    };

    event.getRegistry().registerAll(items);
    event.getRegistry().registerAll(itemblocks);

    RootSystem.LOGGER.debug("All registered items: " + ForgeRegistries.ITEMS.getEntries());
  }

  @SubscribeEvent
  public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    OreGeneration.setupOreGeneration();
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
    return setup(entry, new ResourceLocation(RootSystem.MODID, name));
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
    entry.setRegistryName(registryName);
    return entry;
  }
}
