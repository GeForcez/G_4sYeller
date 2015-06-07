package com.GeForce.G_4sYeller;

import net.md_5.bungee.api.ChatColor;
import static org.bukkit.ChatColor.translateAlternateColorCodes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "[SimpleYeller] invalid or no input");
            m.printHelp(sender);
            return true;
        }
        Player p = getServer().getPlayer(args[0]);
        if((p == null || !getServer().getOnlinePlayers().contains(p)) && (cmd.getName().equalsIgnoreCase("yellp") || cmd.getName().equalsIgnoreCase("yelltp") || cmd.getName().equalsIgnoreCase("yellsp"))) {
            sender.sendMessage(ChatColor.RED + "[SimpleYeller] Player not found or player is not online");
            return true;
        }
        if (getServer().getOnlinePlayers().contains(p) && (cmd.getName().equalsIgnoreCase("yellp") || cmd.getName().equalsIgnoreCase("yelltp") || cmd.getName().equalsIgnoreCase("yellsp"))) {
            for (int i = 1; i < args.length; i++) {
                if (i == args.length - 1) {
                    string += args[i];
                } else {
                    string += args[i] + " ";                    
                }      
            }
        } else {
            for (int i = 0; i < args.length; i++) {
                if (i == args.length - 1) {
                    string += args[i];
                } else {
                    string += args[i] + " ";                    
                }       
            }
        }
        if (cmd.getName().equalsIgnoreCase("yell") && !args[0].equalsIgnoreCase("help") && !args[0].equalsIgnoreCase("about") && string.contains(",")) {
            if (!(sender instanceof Player)) {
                m.printOnlyPlayers(sender);
            } else {
                String[] strings = string.split(",");
                send.sendTitle(strings[0], strings[1]);
            }
            return true;
	} else if (cmd.getName().equalsIgnoreCase("yellt") && !string.contains(",")){
            if (!(sender instanceof Player)) {
                m.printOnlyPlayers(sender);
            } else {
                send.sendTitle(string, "");
            }            
            return true;
	} else if (cmd.getName().equalsIgnoreCase("yells") && !string.contains(",")){
            if (!(sender instanceof Player)) {
                m.printOnlyPlayers(sender);
            } else {
                send.sendTitle("", string);
            }                
            return true;
        } else if (cmd.getName().equalsIgnoreCase("yellp") && !args[0].equalsIgnoreCase("help") && !args[0].equalsIgnoreCase("about") && string.contains(",")) {
            if (!(sender instanceof Player)) {
                m.printOnlyPlayers(sender);
            } else {
                String[] strings = string.split(",");
                send.send(strings[0], strings[1], p);
            }
            return true;
	} else if (cmd.getName().equalsIgnoreCase("yelltp") && !string.contains(",")){
            if (!(sender instanceof Player)) {
                m.printOnlyPlayers(sender);
            } else {
                send.send(string, "", p);
            }            
            return true;
	} else if (cmd.getName().equalsIgnoreCase("yellsp") && !string.contains(",")){
            if (!(sender instanceof Player)) {
                m.printOnlyPlayers(sender);
            } else {
                send.send("", string, p);
            }                
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
