package com.redtek.rootsys.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum Tiers implements IItemTier {
    TEST(3, 1561, 8.0F, 3.0F, 10, () -> {
        return Ingredient.fromItems(Items.DIAMOND);
    });

    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final int harvestLevel;
    private final LazyValue<Ingredient> repairMaterial;

    Tiers(int maxUses, float efficiency, float attackDamage, int enchantability, int harvestLevel, LazyValue<Ingredient> repairMaterial) {
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.harvestLevel = harvestLevel;
        this.repairMaterial = repairMaterial;
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

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
