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

@Command(name = "tppos")
@Permission("eternalcore.tppos")
class TeleportToPositionCommand {

    private final NoticeService noticeService;
    private final TeleportService teleportService;

    @Inject
    TeleportToPositionCommand(NoticeService noticeService, TeleportService teleportService) {
        this.noticeService = noticeService;
        this.teleportService = teleportService;
    }

    @Execute
    void execute(@Context Player player, @Arg Location location) {
        this.teleport(player, location);
    }

    @Execute
    void execute(@Context Viewer viewer, @Arg Location location, @Arg Player target) {
        this.teleport(target, location);

        this.noticeService.create()
            .notice(translation -> translation.teleport().teleportedSpecifiedPlayerToCoordinates())
            .placeholder("{PLAYER}", target.getName())
            .placeholder("{X}", String.valueOf(location.getX()))
            .placeholder("{Y}", String.valueOf(location.getY()))
            .placeholder("{Z}", String.valueOf(location.getX()))
            .viewer(viewer)
            .send();
    }

    private void teleport(Player player, Location location) {
        location.setWorld(player.getWorld());
        this.teleportService.teleport(player, location);

        this.noticeService.create()
            .notice(translation -> translation.teleport().teleportedToCoordinates())
            .placeholder("{X}", String.valueOf(location.getX()))
            .placeholder("{Y}", String.valueOf(location.getY()))
            .placeholder("{Z}", String.valueOf(location.getX()))
            .player(player.getUniqueId())
            .send();
    }
}
