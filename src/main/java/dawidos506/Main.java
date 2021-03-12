package dawidos506;

import dawidos506.managers.FileManager;
import dawidos506.managers.GuiManager;
import dawidos506.objects.Gui;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private Logger log = this.getLogger();
    private FileManager fileManager;
    private GuiManager guiManager;

    @Override
    public void onEnable() {
        log.info("Wczytywanie...");

        fileManager = new FileManager();
        guiManager = new GuiManager();

        fileManager.load();
        guiManager.load();

        log.info("Wczytano pomyslnie!");
    }

    @Override
    public void onDisable() {
        log.info("Wylaczanie...");
    }
}
