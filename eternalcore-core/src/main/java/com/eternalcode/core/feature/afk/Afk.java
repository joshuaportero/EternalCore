package com.eternalcode.core.feature.afk;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents a player being away from keyboard (AFK).
 */
@Getter
public class Afk {

    private final UUID player;
    private final AfkReason afkReason;
    private final Instant start;

    Afk(UUID player, AfkReason afkReason, Instant start) {
        this.player = player;
        this.afkReason = afkReason;
        this.start = start;
    }
}
