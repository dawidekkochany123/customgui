package dawidos506;

import dawidos506.commands.CommandGui;
import dawidos506.managers.FileManager;
import dawidos506.managers.GuiManager;
import dawidos506.managers.InventoryManager;
import dawidos506.objects.Gui;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private Logger log = this.getLogger();
    private FileManager fileManager;
    private GuiManager guiManager;
    private InventoryManager inventoryManager;

    public List<Gui> guis = new ArrayList<>();
    public List<String> names = new ArrayList<>();
    public HashMap<Gui, Inventory> inventories = new HashMap<>();

    @Override
    public void onEnable() {
        log.info("Wczytywanie...");

        fileManager = new FileManager();
        fileManager.load();
        guiManager = new GuiManager();
        guiManager.load();
        inventoryManager = new InventoryManager();
        inventoryManager.setup();

        getCommand("gui").setExecutor(new CommandGui());

        log.info("Wczytano pomyslnie!");
    }

    @Override
    public void onDisable() {
        log.info("Wylaczanie...");
    }
}
