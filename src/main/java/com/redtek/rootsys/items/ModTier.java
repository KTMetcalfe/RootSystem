package com.redtek.rootsys.items;

import com.redtek.rootsys.init.ModBlocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

// Issue with getAttackDamage - attackDamage is defined as float in ItemTier but
// PickaxeItem takes attackDamage in as an int and then converts it to back a float
// This results in an incorrect value shown ingame for the item's attack damage


@SuppressWarnings("SameParameterValue")
public enum ModTier implements IItemTier {

  TEST(3, 1561, 10.0F, 3.0F, 15, () -> {
    return Ingredient.fromItems(ModBlocks.ENLIGHTENED_ORE);
  });

  private final int harvestLevel;
  private final int maxUses;
  private final float efficiency;
  private final float attackDamage;
  private final int enchantability;
  private final LazyValue<Ingredient> repairMaterial;

  ModTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
    this.harvestLevel = harvestLevelIn;
    this.maxUses = maxUsesIn;
    this.efficiency = efficiencyIn;
    this.attackDamage = attackDamageIn;
    this.enchantability = enchantabilityIn;
    this.repairMaterial = new LazyValue<>(repairMaterialIn);
  }

  public int getHarvestLevel() {
    return this.harvestLevel;
  }

  public int getMaxUses() {
    return this.maxUses;
  }

  public float getEfficiency() {
    return this.efficiency;
  }

  public float getAttackDamage() {
    return this.attackDamage;
  }

  public int getEnchantability() {
    return this.enchantability;
  }

  public Ingredient getRepairMaterial() {
    return this.repairMaterial.getValue();
  }
}
