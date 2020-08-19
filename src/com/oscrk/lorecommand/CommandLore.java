package com.oscrk.lorecommand;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandLore implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {	
        	Player player = (Player) sender;
        	if (player.getLevel() < 1) {
        		player.sendMessage(ChatColor.RED + "You need at least 1 level to add lore to your item.");
        	}
        	else {
		
	        	player.setLevel(player.getLevel() - 1);
        		
	        	StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < args.length; i++) {
	                sb.append(args[i]);
	                sb.append(" ");
	            }
	
	            String combinedArgs = sb.toString();
	
	            ItemStack handitem = player.getInventory().getItemInMainHand();
	            ItemMeta meta = handitem.getItemMeta();
	      	  
		      	List<String> loresList = new ArrayList<String>();
		      	loresList.add(combinedArgs);
		      	meta.setLore(loresList);
		      	  
		      	handitem.setItemMeta(meta);
		      	player.getInventory().setItemInMainHand(handitem);
        	}

        }
        return true;
	}
}

	
