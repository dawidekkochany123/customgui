package dawidos506.listeners;

import dawidos506.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private Main pl = Main.getPlugin(Main.class);

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(pl.inventories.containsValue(e.getClickedInventory())) {
            e.setCancelled(true);
        }
    }

}
