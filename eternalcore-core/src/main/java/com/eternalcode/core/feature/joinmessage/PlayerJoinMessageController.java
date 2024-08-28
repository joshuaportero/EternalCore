package com.eternalcode.core.feature.joinmessage;

import com.eternalcode.commons.RandomElementUtil;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Controller;
import com.eternalcode.core.notice.NoticeService;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@Controller
class PlayerJoinMessageController implements Listener {

    private final NoticeService noticeService;

    @Inject
    PlayerJoinMessageController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        this.noticeService.create()
            .notice(translation -> translation.event().welcome())
            .placeholder("{PLAYER}", player.getName())
            .player(player.getUniqueId())
            .sendAsync();

        event.joinMessage(Component.empty());

        this.noticeService.create()
            .noticeOptional(translation -> RandomElementUtil.randomElement(translation.event().joinMessage()))
            .placeholder("{PLAYER}", player.getName())
            .onlinePlayers()
            .sendAsync();
    }
}
