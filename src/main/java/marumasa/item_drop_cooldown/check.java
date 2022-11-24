package marumasa.item_drop_cooldown;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class check extends BukkitRunnable {
    private final minecraft mc;
    private final Config con;
    private final Collection<? extends Player> players;

    public check(final minecraft minecraft, final Config config) {
        mc = minecraft;
        con = config;
        players = minecraft.getServer().getOnlinePlayers();
    }

    @Override
    public void run() {
        for (Player player : players) {
            if (player.hasMetadata("DropItemCount")) {
                final Object meta = MetaData.get(player, mc, "DropItemCount");
                if (meta == null) continue;

                final int DropItemCount = (int) meta;

                // もし ドロップした数が config の MaxDropItem の値より大きい場合 指定した時間 ブロック
                if (DropItemCount > con.max_drop) new BlockTimer(mc, player).runTaskLater(mc, con.block_tick);

                // ドロップ数カウントリセット
                MetaData.set(player, mc, "DropItemCount", 0);
            }
        }
    }
}
