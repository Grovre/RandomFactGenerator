package me.grovre.randomfacts;

import com.mashape.unirest.http.Unirest;
import me.grovre.randomfacts.events.JokeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class RandomFacts extends JavaPlugin {

    public static RandomFacts plugin;

    public static RandomFacts getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        int delay = this.getConfig().getInt("intervalBetweenFacts");

        Runnable joker = () -> {
            String joke = Unirest.get("https://uselessfacts.jsph.pl/random.txt?language=en")
                    .toString()
                    .split("\n")[0]
                    .substring(1);
            try {
                Unirest.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(Player p : Bukkit.getOnlinePlayers()) {
                JokeEvent event = new JokeEvent(p, joke);
                Bukkit.getScheduler().runTask(this, () -> Bukkit.getPluginManager().callEvent(event));
                p.sendMessage(joke);
            }
        };

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, joker, 600, delay);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        try {
            Unirest.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
