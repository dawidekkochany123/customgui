package dawidos506.commands;

import dawidos506.Main;
import dawidos506.managers.GuiManager;
import dawidos506.managers.InventoryManager;
import dawidos506.objects.Gui;
import dawidos506.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGui implements CommandExecutor {

    private Main pl = Main.getPlugin(Main.class);
    private GuiManager guiManager;
    private InventoryManager inventoryManager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        guiManager = new GuiManager();
        inventoryManager = new InventoryManager();
        if(command.getName().equalsIgnoreCase("gui")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage("Ta komenda jest dostepna tylko dla graczy!");
            }
            else {
                Player p = (Player)sender;
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("exit")) {
                        p.closeInventory();
                        p.sendMessage(ChatUtil.fixColor("&aPomyslnie zamknieto GUI!"));
                    }
                    else {
                        if(pl.names.contains(args[0])) {
                            Gui gui = guiManager.getGuiByName(args[0]);
                            if(gui.getPermission()==null || p.hasPermission(gui.getPermission())) {
                                p.openInventory(inventoryManager.getInventoryByGui(gui));
                                p.sendMessage(ChatUtil.fixColor("&aPomyslnie otworzono GUI!"));
                            }
                            else{
                                p.sendMessage(ChatUtil.fixColor("&4Nie masz uprawnien do tej komendy!"));
                            }
                        }
                        else {
                            p.sendMessage(ChatUtil.fixColor("&4Nie ma takiegu GUI!"));
                        }
                    }
                }
                else {
                    p.sendMessage(ChatUtil.fixColor("&cPoprawne uzycie: /gui <nazwa>"));
                }
            }
        }
        return false;
    }
}
