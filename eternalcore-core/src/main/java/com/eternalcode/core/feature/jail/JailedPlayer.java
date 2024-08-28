package com.eternalcode.core.feature.jail;

import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class JailedPlayer {

    private final UUID player;
    @Getter
    private final Instant detainedAt;
    @Getter
    private final Duration prisonTime;
    @Getter
    private final String detainedBy;

    public JailedPlayer(UUID player, Instant detainedAt, Duration prisonTime, String lockedUpBy) {
        this.player = player;
        this.detainedAt = detainedAt;
        this.prisonTime = prisonTime;
        this.detainedBy = lockedUpBy;
    }

    public UUID getPlayerUniqueId() {
        return this.player;
    }

    public boolean isPrisonExpired() {
        return this.detainedAt.plus(this.prisonTime).isBefore(Instant.now());
    }

    public Instant getReleaseTime() {
        return Instant.now().plus(this.prisonTime);
    }

    public Duration getRemainingTime() {
        return Duration.between(Instant.now(), this.detainedAt.plus(this.prisonTime));
    }
}
