package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModItemGroup;
import net.minecraft.block.DispenserBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;

public class EnlightenedArmor extends ArmorItem {

  public EnlightenedArmor(EquipmentSlotType slotType) {
    super(ModArmorMaterial.ENLIGHTENED, slotType, new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP));

    DispenserBlock.registerDispenseBehavior(this, DISPENSER_BEHAVIOR);
  }
}
