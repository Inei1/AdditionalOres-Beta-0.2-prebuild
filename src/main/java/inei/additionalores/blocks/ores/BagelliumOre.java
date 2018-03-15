package inei.additionalores.blocks.ores;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class BagelliumOre extends Block 
{
        public BagelliumOre(Material material) 
        {
                super(material);
                setHardness(9.5F);
                setStepSound(Block.soundTypePiston);
                setBlockName("BagelliumOre");
                setHarvestLevel("pickaxe", 5);
                setBlockTextureName("aores:BagelliumOre");
        }
}