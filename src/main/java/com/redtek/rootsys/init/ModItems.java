package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.items.enlightened.EnlightenedArmor;
import com.redtek.rootsys.items.enlightened.EnlightenedAxe;
import com.redtek.rootsys.items.enlightened.EnlightenedPickaxe;
import com.redtek.rootsys.items.enlightened.EnlightenedShard;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

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

  public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, RootSystem.MODID);


  public static final RegistryObject<Item> ENLIGHTENED_PICKAXE = ITEMS.register("enlightened_pickaxe", () -> new EnlightenedPickaxe());
  public static final RegistryObject<Item> ENLIGHTENED_AXE = ITEMS.register("enlightened_axe", () -> new EnlightenedAxe());

  public static final RegistryObject<Item> ENLIGHTENED_HELMET = ITEMS.register("enlightened_helmet", () -> new EnlightenedArmor(EquipmentSlotType.HEAD));
  public static final RegistryObject<Item> ENLIGHTENED_CHESTPLATE = ITEMS.register("enlightened_chestplate", () -> new EnlightenedArmor(EquipmentSlotType.CHEST));
  public static final RegistryObject<Item> ENLIGHTENED_LEGGINGS = ITEMS.register("enlightened_leggings", () -> new EnlightenedArmor(EquipmentSlotType.LEGS));
  public static final RegistryObject<Item> ENLIGHTENED_BOOTS = ITEMS.register("enlightened_boots", () -> new EnlightenedArmor(EquipmentSlotType.FEET));

  public static final RegistryObject<Item> ENLIGHTENED_SHARD = ITEMS.register("enlightened_shard", () -> new EnlightenedShard());
}
