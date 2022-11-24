package marumasa.item_drop_cooldown;

import org.bukkit.plugin.java.JavaPlugin;

public final class minecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        Config config = new Config(this);
        getServer().getPluginManager().registerEvents(new eventListener(config, this), this);
        new check(this, config).runTaskTimer(this, config.check_tick, config.check_tick);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
