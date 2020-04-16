package com.redtek.rootsys.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.redtek.rootsys.RootSystem;
import com.redtek.rootsys.container.EnlightenedChestContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EnlightenedChestScreen extends ContainerScreen<EnlightenedChestContainer> {

  private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(RootSystem.MODID, "textures/gui/enlightened_chest.png");

  public EnlightenedChestScreen(EnlightenedChestContainer screenContainer, PlayerInventory playerInventory, ITextComponent titleIn) {
    super(screenContainer, playerInventory, titleIn);
    this.guiLeft = 0;
    this.guiTop = 0;
    this.xSize = 174;
    this.ySize = 183;
  }

  @Override
  public void render(final int mouseX, final int mouseY, final float partialTicks) {
    this.renderBackground();
    super.render(mouseX, mouseY, partialTicks);
    this.renderHoveredToolTip(mouseX, mouseY);
  }

  @Override
  protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    this.font.drawString(this.title.getFormattedText(), 8.0f, 6.0f, 4210752);
    this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, 90.0f, 4210752);
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    RenderSystem.color4f(1.0f, 1.0f, 1.0f,1.0f);
    this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
    int x = (this.width - this.xSize) / 2;
    int y = (this.height - this.ySize) / 2;
    this.blit(x, y, 0, 0, xSize, ySize);
  }
}
