package com.redtek.rootsys.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.redtek.rootsys.RootSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MinerBlockScreen extends Screen {

  private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(RootSystem.MODID, "textures/gui/miner_block.png");

  public MinerBlockScreen() {
    super(new TranslationTextComponent("Miner"));
  }

  @Override
  public boolean shouldCloseOnEsc() {
    return true;
  }

  @Override
  public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
    this.drawCenteredString(this.font, this.title.getFormattedText(), this.width / 2, 70, 4210753);
    this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
    this.blit(256,100, 0, 0, 512, 356);
    super.render(p_render_1_, p_render_2_, p_render_3_);
  }

}
