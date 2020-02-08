package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.items.TestAxe;
import com.redtek.rootsys.items.TestPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
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

  public static final Item TEST_PICKAXE = new TestPickaxe().setRegistryName(RootSystem.MODID, "test_pickaxe");

  public static final Item TEST_AXE = new TestAxe().setRegistryName(RootSystem.MODID, "test_axe");
}
