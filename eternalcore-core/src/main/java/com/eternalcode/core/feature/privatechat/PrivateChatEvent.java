package com.eternalcode.core.feature.privatechat;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Event that is called when a player sends a private message to another player.
 */
@Getter
public class PrivateChatEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final UUID sender;
    private final UUID receiver;
    @Setter
    private String content;

    public PrivateChatEvent(UUID sender, UUID receiver, String content) {
        super(true);

        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
