package com.redtek.rootsys.items;

import com.redtek.rootsys.ItemEvents;
import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class TestAxe extends AxeItem {

  public TestAxe() {
    super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

    CompoundNBT nbt = stack.getTag();

    tooltip.add(new TranslationTextComponent("Mode: " + nbt.getString("Mode")));

    super.addInformation(stack, worldIn, tooltip, flagIn);
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

    if (!worldIn.isRemote) {

      ItemStack stack = playerIn.getHeldItem(handIn);
      CompoundNBT nbt = stack.getTag();

      if (nbt.getString("Mode").equals("Vein")) {
        nbt.putString("Mode", "Normal");
      } else {
        nbt.putString("Mode", "Vein");
      }

      playerIn.sendStatusMessage(new TranslationTextComponent("Mode: " + nbt.getString("Mode")), true);

      stack.setTag(nbt);
    }

    return super.onItemRightClick(worldIn, playerIn, handIn);
  }

  @Override
  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    if (!worldIn.isRemote) {

      CompoundNBT nbt = stack.getTag();

      if (nbt.getString("Mode").equals("Vein") && worldIn.getBlockState(pos).getBlock().getRegistryName().toString().contains("log")) {
        stack.setDamage(stack.getDamage() - 1);
        ItemEvents.veinMode(stack, worldIn, state, pos, entityLiving, 32);
        ItemEvents.blocksDestroyed = 0;
      }
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }
}
