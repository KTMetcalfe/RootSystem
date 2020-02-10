package com.redtek.rootsys.items;

import com.redtek.rootsys.ItemEvents;
import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class TestPickaxe extends PickaxeItem{

  public CompoundNBT nbtTag = new CompoundNBT();

  public TestPickaxe() {
    super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

    if (stack.hasTag()) {
      nbtTag = stack.getTag();
    } else {
      stack.setTag(nbtTag);
    }

    tooltip.add(new TranslationTextComponent("Mode: " + stack.getTag().getString("Mode")));

    super.addInformation(stack, worldIn, tooltip, flagIn);
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

    if (!worldIn.isRemote) return null;

    ItemStack activeItem = playerIn.getHeldItem(handIn);

    switch (activeItem.getTag().getString("Mode")) {
      default:
        activeItem.getTag().putString("Mode", "Hammer");
        break;
      case "Hammer":
        activeItem.getTag().putString("Mode", "Vein");
        break;
      case "Vein":
        activeItem.getTag().putString("Mode", "Normal");
        break;
    }

    nbtTag = activeItem.getTag();

    playerIn.sendStatusMessage(new TranslationTextComponent("Mode: " + activeItem.getTag().getString("Mode")), true);

    return super.onItemRightClick(worldIn, playerIn, handIn);
  }

  @Override
  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    stack.setTag(nbtTag);

    switch (stack.getTag().getString("Mode")) {
      case "Hammer":
        ItemEvents.hammerMode(stack, worldIn, state, pos, entityLiving);
        break;
      case "Vein":
        if (worldIn.getBlockState(pos).getBlock().getRegistryName().toString().toLowerCase().endsWith("ore")) {
          stack.setDamage(stack.getDamage()-1);
          ItemEvents.veinMode(stack, worldIn, state, pos, entityLiving, 32);
          ItemEvents.blocksDestroyed = 0;
          break;
        }
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }
}