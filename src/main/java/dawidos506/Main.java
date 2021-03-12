package dawidos506;

import dawidos506.managers.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private Logger log = this.getLogger();
    private FileManager fileManager;

    @Override
    public void onEnable() {
        log.info("Wczytywanie...");

        fileManager = new FileManager();

        fileManager.load();

        log.info("Wczytano pomyslnie!");
    }

    @Override
    public void onDisable() {
        log.info("Wylaczanie...");
    }
}
