package com.redtek.rootsys.init;

import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.container.EnlightenedChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {

  public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, RootSystem.MODID);

  public static final RegistryObject<ContainerType<EnlightenedChestContainer>> ENLIGHTENED_CHEST = CONTAINER_TYPES.register("enlightened_chest", () -> IForgeContainerType.create(EnlightenedChestContainer::new));
}
