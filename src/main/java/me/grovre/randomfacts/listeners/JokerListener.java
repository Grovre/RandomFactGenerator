package me.grovre.randomfacts.listeners;

import me.grovre.randomfacts.events.JokeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class JokerListener implements Listener {

    @EventHandler
    public void onJokerGo(JokeEvent e) {
        System.out.println("Joke fired towards " + e.getPlayer().getName() + "!");
    }
}
