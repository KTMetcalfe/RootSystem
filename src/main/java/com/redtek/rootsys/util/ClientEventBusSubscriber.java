package com.redtek.rootsys.util;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.client.gui.EnlightenedChestScreen;
import com.redtek.rootsys.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RootSystem.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

  @SubscribeEvent
  public static void clientSetup(FMLClientSetupEvent event) {
    ScreenManager.registerFactory(ModContainerTypes.ENLIGHTENED_CHEST.get(), EnlightenedChestScreen::new);
  }
}
