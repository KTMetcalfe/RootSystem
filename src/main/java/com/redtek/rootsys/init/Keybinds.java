package com.redtek.rootsys.init;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Keyboard;
import net.minecraft.client.KeyboardListener;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.awt.event.KeyEvent;

public class Keybinds {
  public static KeyBinding vein;

  public static void register()
  {
    vein = new KeyBinding("key.vein", 82, "key.categories.rootsys");

    ClientRegistry.registerKeyBinding(vein);
  }
}
