package com.eternalcode.core.feature.quitmessage;

import com.eternalcode.commons.RandomElementUtil;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Controller;
import com.eternalcode.core.notice.NoticeService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

@Controller
class PlayerQuitMessageController implements Listener {

    private final NoticeService noticeService;

    @Inject
    PlayerQuitMessageController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @EventHandler
    void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.quitMessage(null);

        this.noticeService.create()
            .noticeOptional(translation -> RandomElementUtil.randomElement(translation.event().quitMessage()))
            .placeholder("{PLAYER}", player.getName())
            .onlinePlayers()
            .send();
    }
}
