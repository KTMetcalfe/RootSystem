package com.redtek.rootsys.init;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;


public class Keybinds {
  public static KeyBinding vein;

  public static void register()
  {
    vein = new KeyBinding("key.vein", 82, "key.categories.rootsys");

    ClientRegistry.registerKeyBinding(vein);
  }
}
