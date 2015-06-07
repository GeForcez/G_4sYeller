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
        send.sendMessage(ChatColor.GREEN + "----------------[SimpleYeller]-----------------");
        send.sendMessage(ChatColor.GREEN + "This is the help page of this command.");
        send.sendMessage(ChatColor.GREEN + "'/yell [Title], [subTitle]'  yells in form of a title and subtitle.");
        send.sendMessage(ChatColor.GREEN + "'/yellt [Title]'  yells in form of a title.");
        send.sendMessage(ChatColor.GREEN + "'/yells [subTitle]'  yells in form of a subtitle.");
        send.sendMessage(ChatColor.GREEN + "'/yellp [Player] [Title], [subTitle]'  yells in form of a title and subtitle to a specific player.");
        send.sendMessage(ChatColor.GREEN + "'/yelltp [Player] [Title]'  yells in form of a title to a specific player.");
        send.sendMessage(ChatColor.GREEN + "'/yellsp [Player] [subTitle]'  yells in form of a subtitle to a specific player.");
        send.sendMessage(ChatColor.GREEN + "---------------End of help page---------------");        
    }
    public void printAbout(CommandSender send) {
        send.sendMessage(ChatColor.GREEN + "----------------[SimpleYeller]-----------------");
        send.sendMessage(ChatColor.GREEN + "This is the about page of this plugin.");
        send.sendMessage(ChatColor.GREEN + "This plugin is made by G_4s");
        send.sendMessage(ChatColor.GREEN + "Version : 1.0 Official Edition");
        send.sendMessage(ChatColor.GREEN + "For Questions, Bugs or problems mailme@ 'support@g-4s.be'");
        send.sendMessage(ChatColor.GREEN + "---------------End of about page---------------");        
    }
    public void printOnlyPlayers(CommandSender send) {
        send.sendMessage(ChatColor.RED + "[SimpleYeller] This command can only be run by a player.");
    }
}
