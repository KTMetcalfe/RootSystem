package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.items.TestItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RootSystem.MODID)
public class ModItems {
    public static final Item TEST_ITEM = new TestItem().setRegistryName(RootSystem.MODID, "test_item");
}
