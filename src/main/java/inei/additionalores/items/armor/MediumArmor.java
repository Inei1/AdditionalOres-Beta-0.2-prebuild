package inei.additionalores.items.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import inei.additionalores.AdditionalOres;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MediumArmor extends ItemArmor{

	public MediumArmor(ArmorMaterial material, int id, int slot) {
		super(material, id, slot);
		this.setCreativeTab(AdditionalOres.tabOres);
		
		if(slot == 0 ){
			this.setTextureName("aores:MediumHelmet");
		}else if(slot == 1){
			this.setTextureName("aores:MediumArmor");	
		}else if(slot == 2){
			this.setTextureName("aores:MediumLegs");
		}else if(slot == 3){
			this.setTextureName("aores:MediumBoots");
		}
		
	}
	
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type){
		if (itemstack.getItem() == AdditionalOres.armorMediumHelm || itemstack.getItem() == AdditionalOres.armorMediumArmor || itemstack.getItem() == AdditionalOres.armorMediumBoots){
			return ("aores:textures/model/armor/Medium_Layer_1.png");
			}
		else if (itemstack.getItem() == AdditionalOres.armorMediumLegs){
			return ("aores:textures/model/armor/Medium_Layer_2.png");
		}else
			return null;
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon("aores:" + this.getUnlocalizedName().substring(5));
	}
}
