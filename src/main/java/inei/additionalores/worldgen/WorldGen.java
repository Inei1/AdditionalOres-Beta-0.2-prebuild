package inei.additionalores.worldgen;

import inei.additionalores.AdditionalOres;
import inei.additionalores.blocks.ores.*;

import java.util.Random;

import sun.awt.resources.awt_es;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator{



	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case 0:
			generateSurface(world, random, chunkX*16,chunkZ*16);
		case -1:
			generateNether(world, random, chunkX*16,chunkZ*16);
		case 1:
			generateEnd(world, random, chunkX*16,chunkZ*16);
			break;
		}
		
	}
	
	private void generateSurface(World world, Random random, int x, int z) {
		//this.addOreSpawn(aores.ore,world,random,x=xpos, z=zpos,max x, max z, maxvein,chance to spawn, miny, maxy);
		this.addOreSpawn(AdditionalOres.oreWeakiumOre, world, random, x , z, 16, 16, 4+random.nextInt(12),100,50,200);
		this.addOreSpawn(AdditionalOres.orePurpliniumOre, world, random, x, z, 16, 16, 4+random.nextInt(8), 15, 35, 55);
		this.addOreSpawn(AdditionalOres.oreOreiteOre, world, random, x, z, 16, 16, 4+random.nextInt(8), 10, 1, 40);
		this.addOreSpawn(AdditionalOres.oreSoftiumOre, world, random, x, z, 16, 16, 4+random.nextInt(8), 9, 1, 30);
		this.addOreSpawn(AdditionalOres.oreGemiumOre, world, random, x, z, 16, 16, 3+random.nextInt(6), 8, 1, 20);
		this.addOreSpawn(AdditionalOres.oreBagelliumOre, world, random, x, z, 16, 16, 3+random.nextInt(6), 7, 1, 20);
		this.addOreSpawn(AdditionalOres.oreCakiumOre, world, random, x, z, 16, 16, 3+random.nextInt(6), 6, 1, 20);
		this.addOreSpawn(AdditionalOres.orePigoliumOre, world, random, x, z, 16, 16, 1+random.nextInt(5), 5, 1, 20);
		this.addOreSpawn(AdditionalOres.oreMediumOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 3, 1, 20);
		this.addOreSpawn(AdditionalOres.oreNetherStarOre, world, random, x, z, 16, 16, 1, 1, 1, 20);
		//this.addOreSpawn(AdditionalOres.oreHardiumOre, world, random, x, z, 16, 16, 2+random.nextInt(6), 10, 5, 30);
		//this.addOreSpawn(AdditionalOres.oreHardiumOre, world, random, x, z, 16, 16, 2+random.nextInt(6), 10, 5, 30);
		//this.addOreSpawn(AdditionalOres.oreHardiumOre, world, random, x, z, 16, 16, 2+random.nextInt(6), 10, 5, 30);
		//this.addOreSpawn(AdditionalOres.oreHardiumOre, world, random, x, z, 16, 16, 2+random.nextInt(6), 10, 5, 30);
		this.addOreSpawn(AdditionalOres.oreCoaliumOre, world, random, x, z, 16, 16, 4+random.nextInt(8), 15, 5, 30);
		}

	private void addOreSpawn(Block ore, World world, Random random,int xpos, int zpos, int maxX, int maxz, int maxvein, int chancetospawn, int miny, int maxy) {
		//i < veins per chunk
		for (int i = 0; i < chancetospawn; i++){
			int posx = xpos+random.nextInt(maxX);
			int posy = miny+random.nextInt(maxy-miny);
			int posz = zpos+random.nextInt(maxz);
			(new WorldGenMinable(ore, maxvein)).generate(world, random, posx, posy, posz);
		}
		
	}

	private void generateEnd(World world, Random random, int x, int z) {
	
		
	}

	private void generateNether(World world, Random random, int x, int z) {
	
		
	}




}
