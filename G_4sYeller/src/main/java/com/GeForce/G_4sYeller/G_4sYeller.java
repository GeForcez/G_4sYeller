package com.GeForce.G_4sYeller;

import java.util.Arrays;
import org.bukkit.ChatColor;
import static org.bukkit.ChatColor.translateAlternateColorCodes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

/**
 *
 * @author G_4s
 * @version 0.1
 * 
 */
public final class G_4sYeller extends JavaPlugin implements CommandExecutor{

    /**
     *
     */
    @Override
    public void onEnable() {
        getLogger().info("[Yeller]: G_4s Yeller plugin is loaded and enabled");
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
	sender send = new sender();
        if (cmd.getName().equalsIgnoreCase("yell") && args.length != 0 && args.length < 4 && !args[0].equalsIgnoreCase("help") && !args[0].equalsIgnoreCase("about")) {
            @SuppressWarnings("UnusedAssignment")
            String header = "";
            @SuppressWarnings("UnusedAssignment")
            String footer = "";
            if ((args[0].isEmpty()) && !Arrays.asList(args).contains("-t")) {
                sender.sendMessage(translateAlternateColorCodes('&', "&4invalid input '/yell [title] , [subtitle]"));
                sender.sendMessage(translateAlternateColorCodes('&', "&4Or '/yell [title]'  or '/yell [subtitle] -t' for no title."));
            }
            String s = "";
            if (args.length < 2) {
                s += args[0];  
            } else {
                for (int i = 0; i < args.length; i++) {
                    if (i == args.length - 1) {
                        s += args[i];
                    } else {
                        s += args[i] + " ";                    
                    }
                }                
            }
            if (s.contains(",")) {
                @SuppressWarnings("MismatchedReadAndWriteOfArray")
                String[] string = s.split(",");
                header = string[0];
                footer = string[1];
                send.sendTitle(header, footer);
            } else {
                header = s;
                footer = s;
                
                if (args[args.length - 1].equalsIgnoreCase("-t")) {
                    send.sendTitle("", footer.replace(" -t", ""));
                } else {
                    send.sendTitle(header, "");
                }
            }
            return true;
	} else if (cmd.getName().equalsIgnoreCase("yell") && args.length != 0 && args.length < 2 && (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("about"))){
            if (args[0].equalsIgnoreCase("help")) {
                if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		} else {
                        sender.sendMessage(ChatColor.GREEN + "----------------[G_4s Yeller]-----------------");
			sender.sendMessage(ChatColor.GREEN + "This is the help page of this command.");
                        sender.sendMessage(ChatColor.GREEN + "'/yell [title] , [subtitle]  yells in form of a title and subtitle.");
                        sender.sendMessage(ChatColor.GREEN + "'/yell [title]  yells in form of a title.");
                        sender.sendMessage(ChatColor.GREEN + "'/yell [subtitle] -t'  yells in form of a subtitle.");
                        sender.sendMessage(ChatColor.GREEN + "---------------End of help page---------------");
		}
            } else if (args[0].equalsIgnoreCase("about")) {
                if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
		} else {
                        sender.sendMessage(ChatColor.GREEN + "----------------[G_4s Yeller]-----------------");
			sender.sendMessage(ChatColor.GREEN + "This is the about page of this plugin.");
                        sender.sendMessage(ChatColor.GREEN + "This plugin is made by G_4s");
                        sender.sendMessage(ChatColor.GREEN + "Version : 0.1 notEvenAlpha Edition");
                        sender.sendMessage(ChatColor.GREEN + "For Questions, Bugs or problems mailme@ 'support@g-4s.be'");
                        sender.sendMessage(ChatColor.GREEN + "---------------End of about page---------------");
		}
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("yell") && args.length == 0){
            sender.sendMessage(ChatColor.GREEN + "----------------[G_4s Yeller]-----------------");
            sender.sendMessage(ChatColor.GREEN + "This is the help page of this command.");
            sender.sendMessage(ChatColor.GREEN + "'/yell [title], [subtitle]  yells in form of a title and subtitle.");
            sender.sendMessage(ChatColor.GREEN + "'/yell [title]  yells in form of a title.");
            sender.sendMessage(ChatColor.GREEN + "'/yell [subtitle] -t'  yells in form of a subtitle.");
            sender.sendMessage(ChatColor.GREEN + "---------------End of help page---------------");
            return true;
        }
	return false; 
    }

    /**
     *
     */
    @Override
    public void onDisable() {
        getLogger().info("[G_4s plugin]: G_4s First plugin is unloaded and disabled :(");
    }
}
