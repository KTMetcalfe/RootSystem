package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.item.PickaxeItem;

public class TestPickaxe extends PickaxeItem{

  public TestPickaxe() {
    super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }
}
