package inei.additionalores.gui;

import org.lwjgl.opengl.GL11;

import inei.additionalores.container.ContainerOreCompressor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiOreCompressor extends GuiContainer {

	public static final ResourceLocation bground = new ResourceLocation("aores:textures/gui/GuiOreCompressor.png");

	public inei.additionalores.tileentity.TileEntityOreCompressor oreCompressor;

	public GuiOreCompressor(InventoryPlayer inventoryPlayer, inei.additionalores.tileentity.TileEntityOreCompressor entity) {
		super(new ContainerOreCompressor(inventoryPlayer, entity));

		this.oreCompressor = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.oreCompressor.hasCustomInventoryName() ? this.oreCompressor.getInventoryName() : I18n.format(this.oreCompressor.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 118, this.ySize - 91 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

			        if (this.oreCompressor.isBurning())
			        {
			            int i1 = this.oreCompressor.getBurnTimeRemainingScaled(13);
			            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
			            i1 = this.oreCompressor.getCookProgressScaled(24);
			            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
			        } 
		 	} 		 

	}
