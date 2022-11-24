package marumasa.item_drop_cooldown;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockTimer extends BukkitRunnable {
    private final Player pl;
    private final minecraft mc;

    public BlockTimer(final minecraft minecraft, final Player player) {
        pl = player;
        mc = minecraft;
        MetaData.set(pl, mc, "BlockDropItem", true);
    }

    @Override
    public void run() {
        MetaData.set(pl, mc, "BlockDropItem", false);
    }
}