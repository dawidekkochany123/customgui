package dawidos506.managers;

import dawidos506.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileManager {

    private Main pl = Main.getPlugin(Main.class);

    private File mainFolder = pl.getDataFolder();
    private File guisFolder = new File(mainFolder, "guis");

    private File configFile = new File(mainFolder, "config.yml");

    private YamlConfiguration configYml = YamlConfiguration.loadConfiguration(configFile);

    public void load() {
        if(!mainFolder.exists())
            mainFolder.mkdir();
        if(!guisFolder.exists())
            guisFolder.mkdir();
        if(!configFile.exists())
            pl.saveResource("config.yml", true);
    }

    public File getMainFolder() {
        return mainFolder;
    }
    public File getGuisFolder() {
        return guisFolder;
    }
    public File getConfigFile() {
        return configFile;
    }
    public YamlConfiguration getConfigYml() {
        return configYml;
    }
}
