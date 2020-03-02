package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.items.enlightened.EnlightenedArmor;
import com.redtek.rootsys.items.enlightened.EnlightenedAxe;
import com.redtek.rootsys.items.enlightened.EnlightenedPickaxe;
import com.redtek.rootsys.items.enlightened.EnlightenedShard;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RootSystem.MODID)
public class ModItems {

  /* TODO
  Add modified armor variants with textures, recipes, and items respective to modifiers

  Ideas:
    Rooted Armor: Strengthen armor, use sticks to make roots to add to base armor

    Flarmor: "Flower Armor", with full setup, flower sword in hand becomes powerful

    Enlighted Armor: Super resistant armor, knocks back attacking mobs, allows you to access enlightened block that dupes items for enlightened crystal

    Enlightened Crystal: Used to craft enlightened block and create powerful armor

    Roots: Created with axe and log and is used to modify base armor

    Flower Sword: Cheap sword thats only useful with flower armor


  */

  public static final Item ENLIGHTENED_PICKAXE = new EnlightenedPickaxe().setRegistryName(RootSystem.MODID, "enlightened_pickaxe");

  public static final Item ENLIGHTENED_AXE = new EnlightenedAxe().setRegistryName(RootSystem.MODID, "enlightened_axe");

  public static final Item ENLIGHTENED_HELMET = new EnlightenedArmor(EquipmentSlotType.HEAD).setRegistryName(RootSystem.MODID, "enlightened_helmet");
  public static final Item ENLIGHTENED_CHESTPLATE = new EnlightenedArmor(EquipmentSlotType.CHEST).setRegistryName(RootSystem.MODID, "enlightened_chestplate");
  public static final Item ENLIGHTENED_LEGGINGS = new EnlightenedArmor(EquipmentSlotType.LEGS).setRegistryName(RootSystem.MODID, "enlightened_leggings");
  public static final Item ENLIGHTENED_BOOTS = new EnlightenedArmor(EquipmentSlotType.FEET).setRegistryName(RootSystem.MODID, "enlightened_boots");

  public static final Item ENLIGHTENED_SHARD = new EnlightenedShard().setRegistryName(RootSystem.MODID, "enlightened_shard");
}
