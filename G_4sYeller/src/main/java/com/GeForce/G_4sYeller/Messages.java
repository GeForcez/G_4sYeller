package com.GeForce.G_4sYeller;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author maxime
 */
public class Messages {
    public Messages() {
        
    }
    public void printHelp(CommandSender send) {
        send.sendMessage(ChatColor.GREEN + "----------------[G_4s Yeller]-----------------");
        send.sendMessage(ChatColor.GREEN + "This is the help page of this command.");
        send.sendMessage(ChatColor.GREEN + "'/yell [title], [subtitle]  yells in form of a title and subtitle.");
        send.sendMessage(ChatColor.GREEN + "'/yellt [title]  yells in form of a title.");
        send.sendMessage(ChatColor.GREEN + "'/yells [subtitle]'  yells in form of a subtitle.");
        send.sendMessage(ChatColor.GREEN + "---------------End of help page---------------");        
    }
    public void printAbout(CommandSender send) {
        send.sendMessage(ChatColor.GREEN + "----------------[G_4s Yeller]-----------------");
        send.sendMessage(ChatColor.GREEN + "This is the about page of this plugin.");
        send.sendMessage(ChatColor.GREEN + "This plugin is made by G_4s");
        send.sendMessage(ChatColor.GREEN + "Version : 0.1 notEvenAlpha Edition");
        send.sendMessage(ChatColor.GREEN + "For Questions, Bugs or problems mailme@ 'support@g-4s.be'");
        send.sendMessage(ChatColor.GREEN + "---------------End of about page---------------");        
    }
}
