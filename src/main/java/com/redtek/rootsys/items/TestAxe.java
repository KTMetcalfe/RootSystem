package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.item.AxeItem;

public class TestAxe extends AxeItem {

  public TestAxe() {
    super(Tiers.POO, (int) Tiers.POO.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }
}
