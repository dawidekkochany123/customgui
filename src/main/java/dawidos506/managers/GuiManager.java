package dawidos506.managers;

import dawidos506.Main;
import dawidos506.objects.Gui;
import dawidos506.objects.Item;
import dawidos506.utils.ChatUtil;
import dawidos506.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuiManager {

    private Main pl = Main.getPlugin(Main.class);
    private FileManager fileManager;

    public void load() {
        fileManager = new FileManager();
        if(fileManager.getGuisFolder().listFiles() != null) {
            for(File f : fileManager.getGuisFolder().listFiles()) {
                YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
                List<Item> content = new ArrayList<>(); {
                    for(String s : yml.getConfigurationSection("content").getKeys(false)) {
                        content.add(new Item(Material.getMaterial(yml.getString("content."+s+".item")), yml.getString("content."+s+".displayname"), yml.getInt("content."+s+".slot"), yml.getInt("content."+s+".count"), ChatUtil.fixColor(yml.getStringList("content."+s+".lore")), yml.getString("content."+s+".command")));
                    }
                }
                Gui gui = new Gui(yml.getString("name"), yml.getString("displayname"), yml.getInt("size"), yml.getString("permission"), content);
                if(gui.getSize()%9 != 0) {
                    System.out.println("BLAD: Liczba slotow w " + gui.getName() + " nie jest podzielna przez 9!");
                }
                else {
                    pl.guis.add(gui);
                    pl.names.add(yml.getString("name"));
                }
            }
        }
        else {
            pl.getLogger().info(ChatUtil.fixColor("&4UWAGA: Brak plikow gui w folderze /guis/"));
        }
    }

    public Gui getGuiByName(String name) {
        for(Gui g : pl.guis) {
            if(g.getName().equalsIgnoreCase(name))
                return g;
        }
        return null;
    }

}
