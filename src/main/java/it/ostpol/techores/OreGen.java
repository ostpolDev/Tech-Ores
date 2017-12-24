package it.ostpol.techores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class OreGen implements IWorldGenerator {

	public OreGen() {
		GameRegistry.registerWorldGenerator(this, 100);
		MinecraftForge.TERRAIN_GEN_BUS.register(this);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int dim = world.provider.getDimension();
		if (dim != -1 && dim != 1) {
			if (world.getWorldType() != WorldType.FLAT)
				gen(world, random, chunkX, chunkZ);
				
		}
	}
	
	public void addOre(IBlockState state, Block block, World world, Random random, int x, int z, int size, int chances, int minY, int maxY) {
		for (int i = 0; i < chances; i++) {
			int posX = x+random.nextInt(16);
			int posY = minY+random.nextInt(maxY-minY);
			int posZ = z+random.nextInt(16);
			new WorldGenMinable(state, size, BlockMatcher.forBlock(block)).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	public void gen(World world, Random random, int x, int z) {
		if (Config.generateOres) {
			 if(Config.generateCopper){
		        this.addOre(TechOreBlocks.COPPER_ORE.getDefaultState(), Blocks.STONE, world, random, x*16, z*16, MathHelper.getInt(random, Config.copperMinChance, Config.copperMaxChance), 15, 0, 45);
		     }
			 if(Config.generateAluminum){
			    this.addOre(TechOreBlocks.ALUMINUM_ORE.getDefaultState(), Blocks.STONE, world, random, x*16, z*16, MathHelper.getInt(random, Config.aluminumMinChance, Config.aluminumMaxChance), 15, 0, 45);
			 }
			 if(Config.generateSilver){
			    this.addOre(TechOreBlocks.SILVER_ORE.getDefaultState(), Blocks.STONE, world, random, x*16, z*16, MathHelper.getInt(random, Config.silverMinChance, Config.silverMaxChance), 9, 0, 35);
			 }
			 if(Config.generateLead){
				this.addOre(TechOreBlocks.LEAD_ORE.getDefaultState(), Blocks.STONE, world, random, x*16, z*16, MathHelper.getInt(random, Config.leadMinChance, Config.leadMaxChance), 9, 0, 35);
			 }
			 if(Config.generateTin){
				this.addOre(TechOreBlocks.TIN_ORE.getDefaultState(), Blocks.STONE, world, random, x*16, z*16, MathHelper.getInt(random, Config.tinMinChance, Config.tinMaxChance), 9, 0, 35);
			 }
		}
	}

}
