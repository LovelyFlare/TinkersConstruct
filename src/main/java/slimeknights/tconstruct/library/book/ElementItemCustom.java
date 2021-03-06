package slimeknights.tconstruct.library.book;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;

import slimeknights.mantle.client.gui.book.element.ElementItem;

public class ElementItemCustom extends ElementItem {

  public int depth = 0;

  public ElementItemCustom(int x, int y, float scale, ItemStack... item) {
    super(x, y, scale, item);
  }

  @Override
  public void draw(int mouseX, int mouseY, float partialTicks, FontRenderer fontRenderer) {
    GlStateManager.translate(0, 0, -depth);
    super.draw(mouseX, mouseY, partialTicks, fontRenderer);
    GlStateManager.translate(0, 0, depth);
  }

  @Override
  public void drawOverlay(int mouseX, int mouseY, float partialTicks, FontRenderer fontRenderer) {
    // no tooltip
  }
}
