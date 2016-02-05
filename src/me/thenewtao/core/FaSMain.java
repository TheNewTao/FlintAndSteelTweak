package me.thenewtao.core;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import me.thenewtao.events.InteractEvent;

public class FaSMain extends JavaPlugin {
	private ArrayList<Material> h = new ArrayList<>();

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new InteractEvent(this), this);
		h.add(Material.WOOD);
		h.add(Material.LEAVES);
		h.add(Material.WOOD_STAIRS);
		h.add(Material.BIRCH_WOOD_STAIRS);
		h.add(Material.JUNGLE_WOOD_STAIRS);
		h.add(Material.SPRUCE_WOOD_STAIRS);
		h.add(Material.DARK_OAK_STAIRS);
		h.add(Material.SPRUCE_WOOD_STAIRS);
		h.add(Material.COAL_BLOCK);
		h.add(Material.BOOKSHELF);
		h.add(Material.CHEST);
		h.add(Material.NETHERRACK);
		h.add(Material.WORKBENCH);
		h.add(Material.LOG);
		h.add(Material.FENCE);
		h.add(Material.FENCE_GATE);
		h.add(Material.TNT);
		h.add(Material.WOOD_STEP);
		File config = new File(getDataFolder(), "config.yml");
		if (!config.exists()) {
			getConfig().addDefault("message", "You can't lit this on fire. ");
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}

	public ArrayList<Material> getMaterials() {
		return h;
	}
}
