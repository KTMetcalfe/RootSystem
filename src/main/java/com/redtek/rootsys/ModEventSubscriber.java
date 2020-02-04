package com.redtek.rootsys;

import com.redtek.rootsys.init.ModBlocks;
import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;

@Mod.EventBusSubscriber(modid = RootSystem.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        final Block[] blocks = {
                ModBlocks.TEST_ORE
        };

        event.getRegistry().registerAll(blocks);
    }

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        final Item[] items = {
                ModItems.TEST_ITEM
        };

        final Item[] itemblocks = {
                new BlockItem(ModBlocks.TEST_ORE, new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)).setRegistryName(RootSystem.MODID, "test_ore")
        };

        event.getRegistry().registerAll(items);
        event.getRegistry().registerAll(itemblocks);
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
        return setup(entry, new ResourceLocation(RootSystem.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
        entry.setRegistryName(registryName);
        return entry;
    }
}
