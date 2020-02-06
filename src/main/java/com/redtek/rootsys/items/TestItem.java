package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class TestItem extends PickaxeItem{
    public TestItem() {

        // Issue with getAttackDamage - attackDamage is defined as float in ItemTier but
        // PickaxeItem takes attackDamage in as an int and then converts it to back a float
        // This results in an incorrect value shown ingame for the item's attack damage

        super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
                .maxStackSize(1)
        );
    }
}
