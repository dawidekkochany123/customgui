package dawidos506.managers;

import dawidos506.Main;
import dawidos506.objects.Gui;
import dawidos506.objects.Item;
import dawidos506.utils.ChatUtil;
import dawidos506.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventoryManager {

    private Main pl = Main.getPlugin(Main.class);

    public void setup() {
        for(Gui g : pl.guis) {
            Inventory inv = Bukkit.createInventory(null, g.getSize(), ChatUtil.fixColor(g.getDisplayName()));
            for(Item i : g.getContent()) {
                inv.setItem(i.getSlot()-1, new ItemBuilder(i.getMaterial(), i.getCount()).setTitle(ChatUtil.fixColor(i.getDisplayName())).addLores(ChatUtil.fixColor(i.getLore())).build());
            }
            pl.inventories.put(g, inv);
        }
    }

    public Inventory getInventoryByGui(Gui g) {
        return pl.inventories.get(g);
    }
    public Gui getGuiByInventory(Inventory inv) {
        for(Gui g : pl.inventories.keySet()) {
            if(pl.inventories.get(g).equals(inv)) {
                return g;
            }
        }
        return null;
    }

}
