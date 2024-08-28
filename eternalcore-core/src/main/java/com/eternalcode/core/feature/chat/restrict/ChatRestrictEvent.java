package com.eternalcode.core.feature.chat.restrict;

import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when player is restricted to use chat, reason: e.g chat cooldown (slowmode), disable chat.
 */
public class ChatRestrictEvent extends Event implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Getter
    private final UUID playerUniqueId;
    private final ChatRestrictCause chatRestrictCause;
    private boolean cancelled;

    public ChatRestrictEvent(UUID playerUniqueId, ChatRestrictCause chatRestrictCause) {
        super(true);
        this.playerUniqueId = playerUniqueId;
        this.chatRestrictCause = chatRestrictCause;
    }

    public ChatRestrictCause getCause() {
        return this.chatRestrictCause;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
