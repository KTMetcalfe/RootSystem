package com.redtek.rootsys.items.enlightened;

import com.redtek.rootsys.init.ModItemGroup;
import net.minecraft.item.Item;

public class EnlightenedShard extends Item {
  public EnlightenedShard() {
    super(new Properties().group(ModItemGroup.MOD_ITEM_GROUP)
        .maxStackSize(16));
  }
}
