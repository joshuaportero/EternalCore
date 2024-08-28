package com.eternalcode.core.feature.sound;

import com.eternalcode.core.config.PluginConfiguration;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Controller;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

@Controller
class PlayerChatSoundListener implements Listener {

    private final PluginConfiguration config;
    private final Server server;

    @Inject
    PlayerChatSoundListener(PluginConfiguration config, Server server) {
        this.config = config;
        this.server = server;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    void playSound(AsyncChatEvent event) {
        PluginConfiguration.Sounds sound = this.config.sound;

        if (!sound.enableAfterChatMessage) {
            return;
        }

        for (Player online : this.server.getOnlinePlayers()) {
            online.playSound(online.getLocation(), sound.afterChatMessage, sound.afterChatMessageVolume, sound.afterChatMessagePitch);
        }
    }
}
