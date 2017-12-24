package it.ostpol.techores;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;

public class Config {

	private static final String CATEGORY_WORLD = "world";
	private static final String CATEGORY_CHANCES = "chances";
	
	public static boolean generateOres = true;
	public static boolean generateCopper = true;
	public static boolean generateSilver = true;
	public static boolean generateAluminum = true;
	public static boolean generateTin = true;
	public static boolean generateLead = true;
	
	public static int copperMinChance = 7;
	public static int copperMaxChance = 9;
	
	public static int aluminumMinChance = 7;
	public static int aluminumMaxChance = 9;
	
	public static int silverMinChance = 4;
	public static int silverMaxChance = 5;
	
	public static int tinMinChance = 7;
	public static int tinMaxChance = 9;
	
	public static int leadMinChance = 6;
	public static int leadMaxChance = 8;
	
	public static void readConfig() {
		Configuration cfg = TechOres.config;
		try {
			cfg.load();
			initGenerarConfig(cfg);
		} catch (Exception e1) {
			TechOres.getLogger().log(Level.ERROR, "Problem loading config file!", e1);
		} finally {
			if (cfg.hasChanged())
				cfg.save();
		}
	}
	
	private static void initGenerarConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_WORLD, "World Configuration");
		cfg.addCustomCategoryComment(CATEGORY_CHANCES, "Chances of every Ore");
		generateOres = cfg.getBoolean("generateOres", CATEGORY_WORLD, generateOres, "Generate Any Ores");
		generateCopper = cfg.getBoolean("generateCopper", CATEGORY_WORLD, generateCopper, "Generate Copper in the world");
		generateSilver = cfg.getBoolean("generateSilver", CATEGORY_WORLD, generateSilver, "Generate Silver in the world");
		generateAluminum = cfg.getBoolean("generateAluminum", CATEGORY_WORLD, generateAluminum, "Generate Aluminum in the world");
		generateTin = cfg.getBoolean("generateAluminum", CATEGORY_WORLD, generateAluminum, "Generate Tin in the world");
		generateLead = cfg.getBoolean("generateAluminum", CATEGORY_WORLD, generateAluminum, "Generate Lead in the world");
		
		copperMinChance = cfg.getInt("copperMinChance", CATEGORY_CHANCES, copperMinChance, 1, 100, "Min Chance of Copper Ore in the World");
		copperMaxChance = cfg.getInt("copperMaxChance", CATEGORY_CHANCES, copperMaxChance, 1, 100, "Max Chance of Copper Ore in the World");
		
		aluminumMinChance = cfg.getInt("aluminumMinChance", CATEGORY_CHANCES, aluminumMinChance, 1, 100, "Min Chance of Aluminum Ore in the World");
		aluminumMaxChance = cfg.getInt("aluminumMaxChance", CATEGORY_CHANCES, aluminumMaxChance, 1, 100, "Max Chance of Aluminum Ore in the World");
		
		silverMinChance = cfg.getInt("silverMinChance", CATEGORY_CHANCES, silverMinChance, 1, 100, "Min Chance of Silver Ore in the World");
		silverMaxChance = cfg.getInt("silverMaxChance", CATEGORY_CHANCES, silverMaxChance, 1, 100, "Max Chance of Silver Ore in the World");
		
		tinMinChance = cfg.getInt("tinMinChance", CATEGORY_CHANCES, tinMinChance, 1, 100, "Min Chance of Tin Ore in the World");
		tinMaxChance = cfg.getInt("tinMaxChance", CATEGORY_CHANCES, tinMaxChance, 1, 100, "Max Chance of Tin Ore in the World");
		
		leadMinChance = cfg.getInt("leadMinChance", CATEGORY_CHANCES, leadMinChance, 1, 100, "Min Chance of Lead Ore in the World");
		leadMaxChance = cfg.getInt("leadMaxChance", CATEGORY_CHANCES, leadMaxChance, 1, 100, "Max Chance of Lead Ore in the World");
	}
	
}
