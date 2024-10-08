package com.eternalcode.core.feature.chat;

import com.eternalcode.core.event.EventCaller;
import com.eternalcode.core.feature.chat.restrict.ChatRestrictCause;
import com.eternalcode.core.feature.chat.restrict.ChatRestrictEvent;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Controller;
import com.eternalcode.core.notice.NoticeService;
import com.eternalcode.core.util.DurationUtil;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.time.Duration;
import java.util.UUID;

@Controller
class ChatManagerController implements Listener {

    static final String CHAT_SLOWMODE_BYPASS_PERMISSION = "eternalcore.chat.noslowmode";
    static final String CHAT_BYPASS_PERMISSION = "eternalcore.chat.bypass";

    private final ChatService chatService;
    private final ChatSettings chatSettings;
    private final NoticeService noticeService;
    private final EventCaller eventCaller;

    @Inject
    ChatManagerController(
        ChatService chatService,
        ChatSettings chatSettings,
        NoticeService noticeService,
        EventCaller eventCaller
    ) {
        this.chatService = chatService;
        this.chatSettings = chatSettings;
        this.noticeService = noticeService;
        this.eventCaller = eventCaller;
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    void onChatSlowMode(AsyncChatEvent event) {
        Player player = event.getPlayer();

        UUID uniqueId = player.getUniqueId();

        if (!this.chatSettings.isChatEnabled() && !player.hasPermission(CHAT_BYPASS_PERMISSION)) {
            this.noticeService.create()
                .notice(translation -> translation.chat().disabledChatInfo())
                .player(uniqueId)
                .send();

            ChatRestrictEvent chatRestrictEvent = this.eventCaller.callEvent(new ChatRestrictEvent(uniqueId, ChatRestrictCause.CHAT_DISABLED));

            if (!chatRestrictEvent.isCancelled()) {
                event.setCancelled(true);
                return;
            }
        }

        if (this.chatService.hasSlowedChat(uniqueId) && !player.hasPermission(CHAT_SLOWMODE_BYPASS_PERMISSION)) {
            ChatRestrictEvent chatRestrictEvent = this.eventCaller.callEvent(new ChatRestrictEvent(uniqueId, ChatRestrictCause.SLOWMODE));

            if (!chatRestrictEvent.isCancelled()) {
                Duration remainingDuration = this.chatService.getRemainingSlowDown(uniqueId);

                this.noticeService
                    .create()
                    .player(uniqueId)
                    .notice(translation -> translation.chat().slowMode())
                    .placeholder("{TIME}", DurationUtil.format(remainingDuration))
                    .send();

                event.setCancelled(true);
            }
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    void markUseChat(AsyncChatEvent event) {
        this.chatService.markUseChat(event.getPlayer().getUniqueId());
    }
}
