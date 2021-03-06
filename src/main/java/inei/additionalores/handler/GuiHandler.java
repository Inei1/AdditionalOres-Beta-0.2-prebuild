package inei.additionalores.handler;

import inei.additionalores.AdditionalOres;
import inei.additionalores.container.ContainerOreCompressor;
import inei.additionalores.gui.GuiOreCompressor;
import inei.additionalores.tileentity.TileEntityOreCompressor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID) {
			case AdditionalOres.guiIDOreCompressor:
				if(entity instanceof TileEntityOreCompressor){
					return new ContainerOreCompressor(player.inventory, (TileEntityOreCompressor) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID) {
			case AdditionalOres.guiIDOreCompressor:
				if(entity instanceof TileEntityOreCompressor){
					return new GuiOreCompressor(player.inventory, (TileEntityOreCompressor) entity);
				}
				return null;
			}
		}
		return null;
	}

}
