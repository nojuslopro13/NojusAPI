package me.nojuslopro.nojusapi.number;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

public class Randomise {
    public static Integer randomnumber(Integer amount, Boolean sendExceptionstoPLR) {
        Random random = new Random();
        Integer number = random.nextInt(amount);
        try {
            if (number == null) {
                throw new Exception("Did not provide a maximum number!");
            }
        } catch (Exception e) {
            if (sendExceptionstoPLR == true) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.hasPermission("nojusapi.receivelogs")) {
                        StringWriter sw = new StringWriter();
                        PrintWriter pw = new PrintWriter(sw);
                        e.printStackTrace(pw);
                        String sStackTrace = sw.toString();
                        player.sendMessage(sStackTrace);
                    }
                }
            }
        }
        return number;
    }

}
