package dawidos506.objects;

import org.bukkit.Material;

import java.util.List;

public class Item {

    private Material material;
    private String displayName, command;
    private int slot, count;
    private List<String> lore;

    public Item(Material material, String displayName, int slot, int count, List<String> lore, String command) {
        this.material = material;
        this.displayName = displayName;
        this.slot = slot;
        this.count = count;
        this.lore = lore;
        this.command = command;
    }

    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getCommand() {
        return command;
    }
    public void setCommand(String command) {
        this.command = command;
    }
    public int getSlot() {
        return slot;
    }
    public void setSlot(int slot) {
        this.slot = slot;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List<String> getLore() {
        return lore;
    }
    public void setLore(List<String> lore) {
        this.lore = lore;
    }
}
