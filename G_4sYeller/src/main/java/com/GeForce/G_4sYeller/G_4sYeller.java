package com.GeForce.G_4sYeller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author G_4s
 * @version 1.1
 */
public final class G_4sYeller extends JavaPlugin implements CommandExecutor{

    /**
     *
     */
    @Override
    public void onEnable() {
        getLogger().info("Your awesome admin yell skills are recharged");
    }

    /**
     *
     * @param sender
     * @param cmd
     * @param label
     * @param args
     * @return
     */
    @Override
    @SuppressWarnings({"ImplicitArrayToString", "static-access", "empty-statement"})
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	PacketSender send = new PacketSender();
        String string = "";
        Messages m = new Messages();
        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                string += args[i];
            } else {
                string += args[i] + " ";                    
            }       
        }
        if (cmd.getName().equalsIgnoreCase("yell") && args.length != 0 && !args[0].equalsIgnoreCase("help") && !args[0].equalsIgnoreCase("about") && string.contains(",")) {
            String[] strings = string.split(",");
            send.sendTitle(strings[0], strings[1]);
            return true;
	} else if (cmd.getName().equalsIgnoreCase("yellt") && args.length != 0 && !string.contains(",")){
            send.sendTitle(string, "");
            return true;
	} else if (cmd.getName().equalsIgnoreCase("yells") && args.length != 0 && !string.contains(",")){
            send.sendTitle("", string);
            return true;
        } else if (cmd.getName().equalsIgnoreCase("yell") && args.length != 0 && args.length < 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("about")) && !string.contains(",")) {
            if (args[0].equalsIgnoreCase("help")) {
                m.printHelp(sender);
            } else if (args[0].equalsIgnoreCase("about")) {
                m.printAbout(sender);
            }
            return true;
        } else {
            m.printHelp(sender);
            return true;
        } 
    }

    /**
     *
     */
    @Override
    public void onDisable() {
        getLogger().info("You lost all your awesome admin yell powers");
    }
}
