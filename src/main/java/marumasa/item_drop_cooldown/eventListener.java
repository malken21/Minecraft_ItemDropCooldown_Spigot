package marumasa.item_drop_cooldown;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class eventListener implements Listener {

    private final Config con;
    private final minecraft mc;

    public eventListener(Config config, minecraft minecraft) {
        con = config;
        mc = minecraft;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        final Player player = event.getPlayer();

        // BlockDropItem が true の場合は アイテムドロップ禁止
        if (player.hasMetadata("BlockDropItem")) {
            final Object meta = MetaData.get(player, mc, "BlockDropItem");
            if (meta != null)
                if ((boolean) meta && con.block_message != null) {
                    event.setCancelled(true);
                    player.sendMessage(String.format(con.block_message, con.block_tick / 20));
                    return;
                }
        }

        // アイテムドロップ数カウント
        int DropItemCount = 0;
        if (player.hasMetadata("DropItemCount")) {
            final Object meta = MetaData.get(player, mc, "DropItemCount");
            if (meta != null) DropItemCount = (int) meta;
        }
        MetaData.set(player, mc, "DropItemCount", DropItemCount + 1);
    }
}