package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModItemGroups;
import net.minecraft.item.Item;

public class TestItem extends Item {

    public TestItem() {
            super(
                    new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
            );
    }
}
