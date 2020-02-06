package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.items.TestAxe;
import com.redtek.rootsys.items.TestPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RootSystem.MODID)
public class ModItems {

  public static final Item TEST_PICKAXE = new TestPickaxe().setRegistryName(RootSystem.MODID, "test_pickaxe");

  public static final Item TEST_AXE = new TestAxe().setRegistryName(RootSystem.MODID, "test_axe");
}
