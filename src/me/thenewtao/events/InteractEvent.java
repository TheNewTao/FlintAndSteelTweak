package me.thenewtao.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.thenewtao.core.FaSMain;

public class InteractEvent implements Listener {

	private FaSMain main;

	public InteractEvent(FaSMain main) {
		this.main = main;
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getItem() != null && e.getItem().getType() != Material.AIR) {
			if (!e.getPlayer().hasPermission("flintandsteel.bypass")) {
				if (e.getPlayer() != null && e.getItem().getType() == Material.FLINT_AND_STEEL) {
					if (e.getClickedBlock() != null && e.getClickedBlock().getType() != Material.AIR
							&& !main.getMaterials().contains(e.getClickedBlock().getType())) {
						String one = ChatColor.YELLOW + "[";
						String two = ChatColor.GOLD + "!";
						String three = ChatColor.YELLOW + "]";
						String four = ChatColor.RED + main.getConfig().getString("message");

						e.getPlayer().sendMessage(one + two + three + four);
						e.setCancelled(true);
					}
				}
			}

		}
	}
}
