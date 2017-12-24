package it.ostpol.techores;

import java.util.ArrayList;
import java.util.List;

import it.ostpol.techores.items.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TechOreBlocks {

	public static List<Block> toRegister = new ArrayList<Block>();
	
	public static Block COPPER_ORE;
	public static Block ALUMINUM_ORE;
	public static Block SILVER_ORE;
	public static Block TIN_ORE;
	public static Block LEAD_ORE;
	
	public static Block COPPER_BLOCK;
	public static Block ALUMINUM_BLOCK;
	public static Block SILVER_BLOCK;
	public static Block TIN_BLOCK;
	public static Block LEAD_BLOCK;
	
	public static void init() {
		COPPER_ORE = new ModBlock("copper_ore", "Copper_ore", Material.ROCK, 1);
		ALUMINUM_ORE = new ModBlock("aluminum_ore", "Aluminum_ore", Material.ROCK, 1);
		SILVER_ORE = new ModBlock("silver_ore", "Silver_ore", Material.ROCK, 2);
		TIN_ORE = new ModBlock("tin_ore", "Tin_ore", Material.ROCK, 1);
		LEAD_ORE = new ModBlock("lead_ore", "Lead_ore", Material.ROCK, 1);
		
		COPPER_BLOCK = new ModBlock("copper_block", "Copper_block", Material.IRON, 1);
		ALUMINUM_BLOCK = new ModBlock("aluminum_block", "Aluminum_block", Material.IRON, 1);
		SILVER_BLOCK = new ModBlock("silver_block", "Silver_block", Material.IRON, 2);
		TIN_BLOCK = new ModBlock("tin_block", "Tin_block", Material.IRON, 1);
		LEAD_BLOCK = new ModBlock("lead_block", "Lead_block", Material.IRON, 1);
	
		toRegister.add(COPPER_ORE);
		toRegister.add(ALUMINUM_ORE);
		toRegister.add(SILVER_ORE);
		toRegister.add(COPPER_BLOCK);
		toRegister.add(ALUMINUM_BLOCK);
		toRegister.add(SILVER_BLOCK);
		toRegister.add(TIN_BLOCK);
		toRegister.add(TIN_ORE);
		toRegister.add(LEAD_BLOCK);
		toRegister.add(LEAD_ORE);
	}
	
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event) {
		for(Block block : toRegister) {
			block.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
			event.getRegistry().register(block);
		}
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		for(Block block : toRegister) {
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
	}
	
	public static void registerRenders() {
		for (Block block : toRegister) {
			registerRender(block);
		}
	}
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
}
