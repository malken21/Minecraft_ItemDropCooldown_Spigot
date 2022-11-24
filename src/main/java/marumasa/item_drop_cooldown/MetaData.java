package marumasa.item_drop_cooldown;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class MetaData {

    // メタデータ 設定
    public static void set(Player player, minecraft minecraft, String key, Object value) {
        player.setMetadata(key, new FixedMetadataValue(
                minecraft,
                value
        ));
    }

    // メタデータ 取得
    public static Object get(Player player, minecraft minecraft, String key) {
        List<MetadataValue> values = player.getMetadata(key);
        for (MetadataValue value : values) {
            final Plugin plugin = value.getOwningPlugin();
            if (plugin == minecraft) {
                return value.value();
            }
        }
        return null;
    }
}
