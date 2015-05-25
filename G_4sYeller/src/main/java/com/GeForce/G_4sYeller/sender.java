package com.GeForce.G_4sYeller;

import static net.md_5.bungee.api.ChatColor.translateAlternateColorCodes;
import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R2.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 *
 * @author maxime
 */
public class sender {
    public sender() {
    }
    public static void sendTitle(String title, String subtitle) {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;

            PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, 15, 75, 10);
            connection.sendPacket(packetPlayOutTimes);

                IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + translateAlternateColorCodes('&', subtitle) + "\"}");
                PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
                connection.sendPacket(packetPlayOutSubTitle);

                IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + translateAlternateColorCodes('&', title) + "\"}");
                PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
                connection.sendPacket(packetPlayOutTitle);
        }
    }
}
