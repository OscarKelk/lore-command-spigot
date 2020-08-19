package com.oscrk.lorecommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
    	getCommand("lore").setExecutor(new CommandLore());
    }
    @Override
    public void onDisable() {

    }
}

