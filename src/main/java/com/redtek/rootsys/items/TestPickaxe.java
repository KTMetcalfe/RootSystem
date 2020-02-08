package com.redtek.rootsys.items;

import com.redtek.rootsys.ItemEvents;
import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.init.ModItemGroups;
import com.redtek.rootsys.init.Tiers;
import net.minecraft.block.BlockState;
import net.minecraft.command.arguments.NBTCompoundTagArgument;
import net.minecraft.command.arguments.NBTTagArgument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class TestPickaxe extends PickaxeItem{

  public TestPickaxe() {
    super(Tiers.TEST, (int) Tiers.TEST.getAttackDamage(), 0, new Properties().group(ModItemGroups.MOD_ITEM_GROUP)
        .maxStackSize(1)
    );
  }

  private CompoundNBT nbtTag = new CompoundNBT();

  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity entityLiving, Hand handIn) {

    if (!worldIn.isRemote) return null;

    RootSystem.sendMessage(String.valueOf(entityLiving.rotationPitch));
    RootSystem.sendMessage(String.valueOf(entityLiving.getHorizontalFacing()));

    ItemStack activeItem = entityLiving.getHeldItem(handIn);

    if (activeItem.hasTag()) {
      nbtTag = activeItem.getTag();
    } else {
      activeItem.setTag(nbtTag);
    }

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

    RootSystem.sendMessage("Tool Mode: " + activeItem.getTag().getString("Mode"));

    return super.onItemRightClick(worldIn, entityLiving, handIn);
  }

  public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {

    switch (stack.getTag().getString("Mode")) {
      case "Hammer":
        ItemEvents.hammerMode(stack, worldIn, state, pos, entityLiving);
        break;
      case "Vein":
        ItemEvents.veinMode(stack, worldIn, state, pos, entityLiving, 32);
        ItemEvents.blocksDestroyed = 0;
        break;
    }

    return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
  }
}