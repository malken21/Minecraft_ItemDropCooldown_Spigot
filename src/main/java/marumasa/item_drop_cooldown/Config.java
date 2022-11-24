package marumasa.item_drop_cooldown;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    public final long check_tick;
    public final int max_drop;
    public final long block_tick;


    public final String block_message;

    public Config(minecraft plugin) {
        plugin.saveDefaultConfig();
        FileConfiguration config = plugin.getConfig();

        check_tick = config.getLong("CheckSecond") * 20;
        max_drop = config.getInt("MaxDropItem");
        block_tick = config.getLong("BlockSecond") * 20;

        block_message = config.getString("BlockMessage");
    }
}