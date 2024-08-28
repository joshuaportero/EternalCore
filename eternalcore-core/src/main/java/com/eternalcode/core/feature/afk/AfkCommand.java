package com.eternalcode.core.feature.afk;

import com.eternalcode.core.config.PluginConfiguration;
import com.eternalcode.core.delay.Delay;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.notice.NoticeService;
import com.eternalcode.core.util.DurationUtil;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import java.time.Duration;
import java.util.UUID;
import org.bukkit.entity.Player;

@Command(name = "afk")
@Permission("eternalcore.afk")
class AfkCommand {

    private final NoticeService noticeService;
    private final PluginConfiguration pluginConfiguration;
    private final AfkService afkService;
    private final Delay<UUID> delay;

    @Inject
    AfkCommand(NoticeService noticeService, PluginConfiguration pluginConfiguration, AfkService afkService) {
        this.noticeService = noticeService;
        this.pluginConfiguration = pluginConfiguration;
        this.afkService = afkService;
        this.delay = new Delay<>(this.pluginConfiguration.afk);
    }

    @Execute
    void execute(@Context Player player) {
        UUID uuid = player.getUniqueId();

        if (this.delay.hasDelay(uuid)) {
            Duration time = this.delay.getDurationToExpire(uuid);

            this.noticeService
                .create()
                .notice(translation -> translation.afk().afkDelay())
                .placeholder("{TIME}", DurationUtil.format(time))
                .player(uuid)
                .send();

            return;
        }

        this.afkService.switchAfk(uuid, AfkReason.COMMAND);

        if (player.hasPermission("eternalcore.afk.bypass")) {
            return;
        }

        this.delay.markDelay(uuid, this.pluginConfiguration.afk.delay());
    }
}
