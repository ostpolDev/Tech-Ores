package it.ostpol.techores;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.ostpol.techores.proxy.Proxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(name = TechOres.NAME, modid = TechOres.MOD_ID, version = TechOres.VERSION, acceptedMinecraftVersions = TechOres.MC_VERSION)
public class TechOres {

	public static final String NAME = "Tech Ores";
	public static final String MOD_ID = "techores";
	public static final String VERSION = "1.1";
	public static final String MC_VERSION = "[1.12.2]";
	
	@Instance
	public static TechOres instance;
	
	public static Configuration config;
	
	public static Logger logger;
	
	public static Logger getLogger() {
		if (logger == null)
			logger = LogManager.getFormatterLogger(MOD_ID);
		return logger;
	}
	
	@SidedProxy(clientSide = "it.ostpol.techores.proxy.ClientProxy", serverSide = "it.ostpol.techores.proxy.ServerProxy")
	public static Proxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {		
		MinecraftForge.EVENT_BUS.register(TechOreBlocks.class);
		MinecraftForge.EVENT_BUS.register(TechOreItems.class);
		
		TechOreBlocks.init();
		TechOreItems.init();
		
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), MOD_ID+".cfg"));
		Config.readConfig();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
		
		OreDictionary.registerOre("oreCopper", TechOreBlocks.COPPER_ORE);
		OreDictionary.registerOre("oreAluminum", TechOreBlocks.ALUMINUM_ORE);
		OreDictionary.registerOre("oreSilver", TechOreBlocks.SILVER_ORE);
		OreDictionary.registerOre("oreLead", TechOreBlocks.LEAD_ORE);
		OreDictionary.registerOre("oreTin", TechOreBlocks.TIN_ORE);
		OreDictionary.registerOre("blockCopper", TechOreBlocks.COPPER_BLOCK);
		OreDictionary.registerOre("blockAluminum", TechOreBlocks.ALUMINUM_BLOCK);
		OreDictionary.registerOre("blockSilver", TechOreBlocks.SILVER_BLOCK);
		OreDictionary.registerOre("blockLead", TechOreBlocks.LEAD_BLOCK);
		OreDictionary.registerOre("blockTin", TechOreBlocks.TIN_BLOCK);
		
		
		OreDictionary.registerOre("ingotCopper", TechOreItems.COPPER_INGOT);
		OreDictionary.registerOre("ingotSilver", TechOreItems.SILVER_INGOT);
		OreDictionary.registerOre("ingotAluminum", TechOreItems.ALUMINUM_INGOT);
		OreDictionary.registerOre("ingotTin", TechOreItems.TIN_INGOT);
		OreDictionary.registerOre("ingotLead", TechOreItems.LEAD_INGOT);
		OreDictionary.registerOre("dustCopper", TechOreItems.COPPER_DUST);
		OreDictionary.registerOre("dustAluminum", TechOreItems.ALUMINUM_DUST);
		OreDictionary.registerOre("dustSilver", TechOreItems.SILVER_DUST);
		OreDictionary.registerOre("dustLead", TechOreItems.LEAD_DUST);
		OreDictionary.registerOre("dustTin", TechOreItems.TIN_DUST);
		
		GameRegistry.addSmelting(TechOreBlocks.COPPER_ORE, new ItemStack(TechOreItems.COPPER_INGOT, 1), 0.2f);
		GameRegistry.addSmelting(TechOreBlocks.ALUMINUM_ORE, new ItemStack(TechOreItems.ALUMINUM_INGOT, 1), 0.2f);
		GameRegistry.addSmelting(TechOreBlocks.SILVER_ORE, new ItemStack(TechOreItems.SILVER_INGOT, 1), 0.2f);
		GameRegistry.addSmelting(TechOreBlocks.TIN_ORE, new ItemStack(TechOreItems.TIN_INGOT, 1), 0.2f);
		GameRegistry.addSmelting(TechOreBlocks.LEAD_ORE, new ItemStack(TechOreItems.LEAD_INGOT, 1), 0.2f);
		
		new OreGen();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (config.hasChanged())
			config.save();
	}
}
