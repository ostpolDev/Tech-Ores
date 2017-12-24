package it.ostpol.techores;

import java.util.ArrayList;
import java.util.List;

import it.ostpol.techores.items.ModItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TechOreItems {
	
	public static List<Item> toRegister = new ArrayList<Item>();

	public static Item COPPER_INGOT;
	public static Item SILVER_INGOT;
	public static Item ALUMINUM_INGOT;
	public static Item TIN_INGOT;
	public static Item LEAD_INGOT;
	
	public static Item COPPER_DUST;
	public static Item SILVER_DUST;
	public static Item ALUMINUM_DUST;
	public static Item TIN_DUST;
	public static Item LEAD_DUST;
	
	public static void init() {
		COPPER_INGOT = new ModItem("copper_ingot", "Copper_ingot");
		SILVER_INGOT = new ModItem("silver_ingot", "Silver_ingot");
		ALUMINUM_INGOT = new ModItem("aluminum_ingot", "Aluminum_ingot");
		TIN_INGOT = new ModItem("tin_ingot", "Tin_ingot");
		LEAD_INGOT = new ModItem("lead_ingot", "Lead_ingot");
		
		COPPER_DUST = new ModItem("copper_dust", "Copper_dust");
		SILVER_DUST = new ModItem("silver_dust", "Silver_dust");
		ALUMINUM_DUST = new ModItem("aluminum_dust", "Aluminum_dust");
		TIN_DUST = new ModItem("tin_dust", "Tin_dust");
		LEAD_DUST = new ModItem("lead_dust", "Lead_dust");
		
		toRegister.add(COPPER_INGOT);
		toRegister.add(SILVER_INGOT);
		toRegister.add(ALUMINUM_INGOT);
		toRegister.add(TIN_INGOT);
		toRegister.add(LEAD_INGOT);
		
		toRegister.add(COPPER_DUST);
		toRegister.add(SILVER_DUST);
		toRegister.add(ALUMINUM_DUST);
		toRegister.add(TIN_DUST);
		toRegister.add(LEAD_DUST);
	}
	
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Item> event) {
		for(Item item : toRegister) {
			item.setCreativeTab(CreativeTabs.MATERIALS);
			event.getRegistry().register(item);
		}
	}
	
	public static void registerRenders() {
		for (Item item : toRegister) {
			registerRender(item);
		}
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
