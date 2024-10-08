package com.eternalcode.core.feature.join;

import com.eternalcode.commons.bukkit.position.Position;
import com.eternalcode.commons.bukkit.position.PositionAdapter;
import com.eternalcode.core.config.LocationsConfiguration;
import com.eternalcode.core.config.PluginConfiguration;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Controller;
import io.papermc.lib.PaperLib;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class PlayerJoinController implements Listener {

    private static final String WARNING = "Spawn is not set! Set it using the /setspawn command";
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerJoinController.class);

    private final LocationsConfiguration locationsConfiguration;
    private final PluginConfiguration pluginConfiguration;

    @Inject
    public PlayerJoinController(LocationsConfiguration locationsConfiguration, PluginConfiguration pluginConfiguration) {
        this.locationsConfiguration = locationsConfiguration;
        this.pluginConfiguration = pluginConfiguration;
    }

    @EventHandler
    void onFirstJoin(PlayerJoinEvent event) {
        if (!this.pluginConfiguration.join.teleportToSpawnOnFirstJoin) {
            return;
        }

        Player player = event.getPlayer();

        if (player.hasPlayedBefore()) {
            return;
        }

        this.teleportToSpawn(player);
    }

    @EventHandler
    void onJoin(PlayerJoinEvent event) {
        if (!this.pluginConfiguration.join.teleportToSpawnOnJoin) {
            return;
        }
        Player player = event.getPlayer();

        this.teleportToSpawn(player);
    }

    void teleportToSpawn(Player player) {
        Position spawnPosition = this.locationsConfiguration.spawn;

        if (spawnPosition == null || spawnPosition.isNoneWorld()) {
            LOGGER.warn(WARNING);

            return;
        }

        Location spawnLocation = PositionAdapter.convert(spawnPosition);
        PaperLib.teleportAsync(player, spawnLocation);
    }
}
