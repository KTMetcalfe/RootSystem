package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups {

  static class ModItemGroup extends ItemGroup {

    private final Supplier<ItemStack> iconSupplier;

    ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
      super(name);
      this.iconSupplier = iconSupplier;
    }

    @Override
    public ItemStack createIcon() {
      return iconSupplier.get();
    }
  }

  public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(RootSystem.MODID, () -> new ItemStack(ModItems.TEST_AXE));
}
