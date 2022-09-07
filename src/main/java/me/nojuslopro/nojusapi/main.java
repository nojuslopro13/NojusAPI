package me.nojuslopro.nojusapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Plugin is enabling.");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Plugin is disabling.");
    }
}
