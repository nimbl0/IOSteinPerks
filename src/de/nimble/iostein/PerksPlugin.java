package de.nimble.iostein;

import de.nimble.iostein.commands.NPCCommand;
import de.nimble.iostein.commands.PerkCommand;
import de.nimble.iostein.config.GeneralPerkConfig;
import de.nimble.iostein.config.PerkConfig;
import de.nimble.iostein.listener.DamageListener;
import de.nimble.iostein.listener.FoodLevelChangeListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PerksPlugin extends JavaPlugin {

    public static PerkConfig perkConfig;
    public static GeneralPerkConfig generalConfig;

    @Override
    public void onEnable() {
        perkConfig = new PerkConfig("perks");
        generalConfig = new GeneralPerkConfig();

        loadConfig();
        loadCommands();
        registerEvents(getServer().getPluginManager());
    }

    @Override
    public void onDisable() {

    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void loadCommands() {
        getCommand("perks").setExecutor(new PerkCommand());
        getCommand("spawnNPC").setExecutor(new NPCCommand());
    }

    public void registerEvents(PluginManager pluginManager) {
        pluginManager.registerEvents(new DamageListener(), this);
        pluginManager.registerEvents(new FoodLevelChangeListener(), this);
    }

}
