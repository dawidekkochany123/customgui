package dawidos506.objects;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class Gui {

    private String name, displayName, permission;
    private int size;
    private List<Item> content;

    public Gui(String name, String displayName, int size, String permission, List<Item> content) {
        this.name = name;
        this.displayName = displayName;
        this.size = size;
        this.permission = permission;
        this.content = content;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getPermission() {
        return permission;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public List<Item> getContent() {
        return content;
    }
    public void setContent(List<Item> content) {
        this.content = content;
    }
}
