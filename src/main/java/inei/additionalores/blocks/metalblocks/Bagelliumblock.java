package inei.additionalores.blocks.metalblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Bagelliumblock extends Block {

	public Bagelliumblock(Material material) {
		super(material);
		setHardness(11.0F);
		setBlockName("BagelliumBlock");
		setStepSound(soundTypePiston);
        setHarvestLevel("pickaxe", 5);
        setBlockTextureName("aores:BagelliumBlock");
	}

}
