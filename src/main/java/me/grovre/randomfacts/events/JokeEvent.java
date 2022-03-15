package me.grovre.randomfacts.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.nullness.qual.NonNull;

public class JokeEvent extends Event implements Cancellable {

    private boolean cancelled;
    private final Player player;
    private final String joke;
    private static final HandlerList handlers = new HandlerList();

    public JokeEvent(Player player,String joke) {
        cancelled = false;
        this.player = player;
        this.joke = joke;
    }

    public Player getPlayer() {
        return player;
    }

    public String getJoke() {
        return joke;
    }

    @Override
    @NonNull
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
