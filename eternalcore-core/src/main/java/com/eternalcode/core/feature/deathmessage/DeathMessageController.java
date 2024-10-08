package com.eternalcode.core.feature.deathmessage;

import com.eternalcode.commons.RandomElementUtil;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Controller;
import com.eternalcode.core.notice.NoticeService;
import com.eternalcode.multification.notice.Notice;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

@Controller
class DeathMessageController implements Listener {

    private final NoticeService noticeService;

    @Inject
    DeathMessageController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @EventHandler
    void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        event.deathMessage(null);

        if (player.getKiller() != null) {
            this.noticeService.create()
                .noticeOptional(translation -> RandomElementUtil.randomElement(translation.event().deathMessage()))
                .placeholder("{PLAYER}", player.getName())
                .placeholder("{KILLER}", player.getKiller().getName())
                .onlinePlayers()
                .send();

            return;
        }

        EntityDamageEvent lastDamageCause = player.getLastDamageCause();

        if (lastDamageCause == null) {
            this.noticeService.create()
                .noticeOptional(translation -> RandomElementUtil.randomElement(translation.event().unknownDeathCause()))
                .placeholder("{PLAYER}", player.getName())
                .onlinePlayers()
                .send();
            return;
        }

        this.noticeService.create()
            .noticeOptional(translation -> {
                EntityDamageEvent.DamageCause cause = lastDamageCause.getCause();

                List<Notice> notifications = translation.event().deathMessageByDamageCause().get(cause);

                if (notifications == null) {
                    return RandomElementUtil.randomElement(translation.event().unknownDeathCause());
                }

                return RandomElementUtil.randomElement(notifications);
            })
            .placeholder("{PLAYER}", player.getName())
            .onlinePlayers()
            .send();
    }
}
