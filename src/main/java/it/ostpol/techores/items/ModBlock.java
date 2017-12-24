package it.ostpol.techores.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlock extends Block {

	public ModBlock(String unlocalizedName, String registryName, Material mat, int harvestLevel) {
		super(mat);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(registryName);
		setHarvestLevel("pickaxe", harvestLevel);
		setHardness(2);
	}
	
}
