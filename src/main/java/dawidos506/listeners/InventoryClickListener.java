package dawidos506.listeners;

import dawidos506.Main;
import dawidos506.managers.InventoryManager;
import dawidos506.objects.Gui;
import dawidos506.objects.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private Main pl = Main.getPlugin(Main.class);
    private InventoryManager inventoryManager;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        inventoryManager = new InventoryManager();
        Player p = (Player) e.getWhoClicked();
        if(pl.inventories.containsValue(e.getClickedInventory())) {
            e.setCancelled(true);
            Gui g = inventoryManager.getGuiByInventory(e.getClickedInventory());
            for(Item i : g.getContent()) {
                if(e.getSlot() == i.getSlot()-1) {
                    p.chat("/" + i.getCommand());
                }
            }
        }
    }

}
