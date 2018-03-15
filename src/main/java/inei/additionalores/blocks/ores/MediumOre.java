package inei.additionalores.blocks.ores;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class MediumOre extends Block 
{
        public MediumOre(Material material) 
        {
                super(material);
                setHardness(27.5F);
                setStepSound(Block.soundTypePiston);
                setBlockName("MediumOre");
                setHarvestLevel("pickaxe", 8);
                setBlockTextureName("aores:MediumOre");
        }
}