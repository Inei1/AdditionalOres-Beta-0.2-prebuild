package inei.additionalores.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerOreCompressor extends Container{
	
	private inei.additionalores.tileentity.TileEntityOreCompressor oreCompressor;
	
	//ticks the furnace will burn
	public int lastBurnTime;
	
	//number of ticks a fresh copy of the currently burning item would keep the furnace burning
	public int lastCurrentItemBurnTime;
	
	//number of ticks item has been cooking for
	public int lastCookTime;

	public ContainerOreCompressor(InventoryPlayer inventory, inei.additionalores.tileentity.TileEntityOreCompressor tileentity){
		this.oreCompressor = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {	
		return true;
	}

public void addCraftingToCrafters (ICrafting icrafting){
	super.addCraftingToCrafters(icrafting);
	icrafting.sendProgressBarUpdate(this, 0, this.oreCompressor.cookTime);
	icrafting.sendProgressBarUpdate(this, 1, this.oreCompressor.burnTime);
	icrafting.sendProgressBarUpdate(this, 2, this.oreCompressor.currentItemBurnTime);
}

public void detectAndSendChanges(){
	super.detectAndSendChanges();
	for(int i = 0; i < this.crafters.size(); i++){
		ICrafting icrafting = (ICrafting) this.crafters.get(i);
		
		if(this.lastCookTime != this.oreCompressor.cookTime){
			icrafting.sendProgressBarUpdate(this, 0, this.oreCompressor.cookTime);
		}
		if(this.lastBurnTime != this.oreCompressor.burnTime){
			icrafting.sendProgressBarUpdate(this, 1, this.oreCompressor.burnTime);
	}
		if(this.lastCurrentItemBurnTime != this.oreCompressor.currentItemBurnTime){
			icrafting.sendProgressBarUpdate(this, 2, this.oreCompressor.currentItemBurnTime);
		}
	}
	
	this.lastCookTime = this.oreCompressor.cookTime;
	this.lastBurnTime = this.oreCompressor.burnTime;
	this.lastCurrentItemBurnTime = this.oreCompressor.currentItemBurnTime;
}

@SideOnly(Side.CLIENT)
public void updateProgressBar(int par1, int par2){
	
	if(par1 == 0){
		this.oreCompressor.cookTime = par2;
	}
	if(par1 == 1){
		this.oreCompressor.burnTime = par2;
	}
	if(par1 == 2){
		this.oreCompressor.currentItemBurnTime = par2;
	}
	
}
public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
{
    ItemStack itemstack = null;
    Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

    if (slot != null && slot.getHasStack())
    {
        ItemStack itemstack1 = slot.getStack();
        itemstack = itemstack1.copy();

        if (p_82846_2_ == 2)
        {
            if (!this.mergeItemStack(itemstack1, 3, 39, true))
            {
                return null;
            }

            slot.onSlotChange(itemstack1, itemstack);
        }
        else if (p_82846_2_ != 1 && p_82846_2_ != 0)
        {
            if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
            {
                if (!this.mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }
            else if (TileEntityFurnace.isItemFuel(itemstack1))
            {
                if (!this.mergeItemStack(itemstack1, 1, 2, false))
                {
                    return null;
                }
            }
            else if (p_82846_2_ >= 3 && p_82846_2_ < 30)
            {
                if (!this.mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            }
            else if (p_82846_2_ >= 30 && p_82846_2_ < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
            {
                return null;
            }
        }
        else if (!this.mergeItemStack(itemstack1, 3, 39, false))
        {
            return null;
        }

        if (itemstack1.stackSize == 0)
        {
            slot.putStack((ItemStack)null);
        }
        else
        {
            slot.onSlotChanged();
        }

        if (itemstack1.stackSize == itemstack.stackSize)
        {
            return null;
        }

        slot.onPickupFromSlot(p_82846_1_, itemstack1);
    }

    return itemstack;
}
}






