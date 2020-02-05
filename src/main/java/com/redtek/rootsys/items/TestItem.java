package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModItemGroups;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class TestItem extends PickaxeItem {
    public TestItem() {
        super(ItemTier.DIAMOND, ItemTier.DIAMOND.getMaxUses(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
                .maxStackSize(1)
                .maxDamage(2000)
                .addToolType(ToolType.PICKAXE, 2)
        );
    }
}
