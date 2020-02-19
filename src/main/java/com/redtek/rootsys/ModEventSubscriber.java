package com.redtek.rootsys;

import com.redtek.rootsys.init.ModBlocks;
import com.redtek.rootsys.init.ModItemGroup;
import com.redtek.rootsys.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = RootSystem.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

  @SubscribeEvent
  public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {

    final Block[] blocks = {
        ModBlocks.ENLIGHTENED_ORE
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
        ModItems.ENLIGHTENED_BOOTS
    };

    final Item[] itemblocks = {
        new BlockItem(ModBlocks.ENLIGHTENED_ORE, new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP)).setRegistryName(RootSystem.MODID, "enlightened_ore")
    };

    event.getRegistry().registerAll(items);
    event.getRegistry().registerAll(itemblocks);

    RootSystem.LOGGER.debug("All registered items: " + ForgeRegistries.ITEMS.getEntries());
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
    return setup(entry, new ResourceLocation(RootSystem.MODID, name));
  }

  public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
    entry.setRegistryName(registryName);
    return entry;
  }
}
