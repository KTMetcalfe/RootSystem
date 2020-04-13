package com.redtek.rootsys.items.enlightened;

import com.redtek.rootsys.init.ModItemGroup;
import com.redtek.rootsys.items.ItemEvents;
import com.redtek.rootsys.items.ModTier;
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

public class EnlightenedPickaxe extends PickaxeItem {

  public EnlightenedPickaxe() {
    super(ModTier.TEST, (int) ModTier.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroup.MOD_ITEM_GROUP)
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

      switch (nbt.getString("Mode")) {
        default:
          nbt.putString("Mode", "Hammer");
          break;
        case "Hammer":
          nbt.putString("Mode", "Vein");
          break;
        case "Vein":
          nbt.putString("Mode", "Normal");
          break;
      }

      playerIn.sendStatusMessage(new TranslationTextComponent("Mode: " + nbt.getString("Mode")), true);

      stack.setTag(nbt);

//      playerIn.sendMessage(new TranslationTextComponent(Integer.toString(Keybinds.vein.getKey().getKeyCode())));
    }

    return super.onItemRightClick(worldIn, playerIn, handIn);
  }

  @Override
  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    if (!worldIn.isRemote) {

      CompoundNBT nbt = stack.getTag();

      switch (nbt.getString("Mode")) {
        case "Hammer":
          ItemEvents.hammerMode(stack, worldIn, state, pos, entityLiving);
          break;
        case "Vein":
          if (worldIn.getBlockState(pos).getBlock().getRegistryName().toString().toLowerCase().endsWith("ore")) {
            stack.setDamage(stack.getDamage() - 1);
            ItemEvents.veinMode(stack, worldIn, state, pos, entityLiving, 32, pos);
            ItemEvents.blocksDestroyed = 0;
            break;
          }
          else {break;}
      }
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }
}