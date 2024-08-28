package com.eternalcode.core.feature.teleport.command;

import com.eternalcode.core.feature.teleport.TeleportService;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.notice.NoticeService;
import com.eternalcode.core.viewer.Viewer;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Optional;

@Command(name = "back")
class TeleportBackCommand {

    private final TeleportService teleportService;
    private final NoticeService noticeService;

    @Inject
    TeleportBackCommand(TeleportService teleportService, NoticeService noticeService) {
        this.teleportService = teleportService;
        this.noticeService = noticeService;
    }

    @Execute
    @Permission("eternalcore.back")
    void execute(@Context Player player) {
        Optional<Location> location = this.teleportService.getLastLocation(player.getUniqueId());

        if (location.isEmpty()) {
            this.noticeService.player(player.getUniqueId(), translation -> translation.teleport().lastLocationNoExist());

            return;
        }

        this.teleportService.teleport(player, location.get());
        this.noticeService.player(player.getUniqueId(), translation -> translation.teleport().teleportedToLastLocation());
    }

    @Execute
    @Permission("eternalcore.back.other")
    void execute(@Context Viewer viewer, @Arg Player player) {
        Optional<Location> location = this.teleportService.getLastLocation(player.getUniqueId());

        if (location.isEmpty()) {
            this.noticeService.viewer(viewer, translation -> translation.teleport().lastLocationNoExist());

            return;
        }

        this.teleportService.teleport(player, location.get());

        this.noticeService.player(player.getUniqueId(), translation -> translation.teleport().teleportedToLastLocation());

        this.noticeService.create()
            .viewer(viewer)
            .notice(translation -> translation.teleport().teleportedSpecifiedPlayerLastLocation())
            .placeholder("{PLAYER}", player.getName())
            .send();
    }
}
