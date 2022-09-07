package me.nojuslopro.nojusapi.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PotionEffect {
    public static void givePotionEffectToPlayer(Player player, PotionEffectType potionEffectType, Integer amplifier, Integer duration, Boolean sendExceptionstoPLR) {
        try {

            if (player == null) {
                throw new Exception("No player provided");
            }
            if (potionEffectType == null) {
                throw new Exception("No Potion effect provided");
            }

            if (amplifier == null) {
                throw new Exception("No amplifier provided");
            }
            if (duration == null) {
                throw new Exception("No duration provided");
            }

            player.addPotionEffect(new org.bukkit.potion.PotionEffect(potionEffectType, duration, amplifier));
        }catch (Exception e) {
            if (sendExceptionstoPLR == true) {
                for (Player onlineplayers : Bukkit.getOnlinePlayers()) {
                    if (player.hasPermission("nojusapi.receivelogs")) {
                        StringWriter sw = new StringWriter();
                        PrintWriter pw = new PrintWriter(sw);
                        e.printStackTrace(pw);
                        String sStackTrace = sw.toString();
                        onlineplayers.sendMessage(sStackTrace);
                    }
                }
            }
        }
    }
}
