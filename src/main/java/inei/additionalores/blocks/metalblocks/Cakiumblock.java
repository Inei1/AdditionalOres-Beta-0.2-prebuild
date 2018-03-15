package inei.additionalores.blocks.metalblocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Cakiumblock extends Block {

	public Cakiumblock(Material material) {
		super(material);
		setHardness(20.0F);
		setBlockName("CakiumBlock");
		setStepSound(soundTypePiston);
        setHarvestLevel("pickaxe", 6);
        setBlockTextureName("aores:CakiumBlock");
	}

}
