package com.eternalcode.core.feature.privatechat;

import com.eternalcode.core.event.EventCaller;
import com.eternalcode.core.injector.annotations.Inject;
import com.eternalcode.core.injector.annotations.component.Service;
import com.eternalcode.core.notice.NoticeService;
import com.eternalcode.core.user.User;
import com.eternalcode.core.user.UserManager;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.entity.Player;

import java.time.Duration;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
class PrivateChatServiceImpl implements PrivateChatService {

    private final NoticeService noticeService;
    private final UserManager userManager;
    private final PrivateChatPresenter presenter;
    private final EventCaller eventCaller;

    private final Cache<UUID, UUID> replies = CacheBuilder.newBuilder()
        .expireAfterWrite(Duration.ofHours(1))
        .build();

    @Inject
    PrivateChatServiceImpl(NoticeService noticeService, UserManager userManager, EventCaller eventCaller) {
        this.noticeService = noticeService;
        this.userManager = userManager;
        this.eventCaller = eventCaller;

        this.presenter = new PrivateChatPresenter(noticeService);
    }

    void privateMessage(User sender, User target, String message) {
        if (target.getClientSettings().isOffline()) {
            this.noticeService.player(sender.getUniqueId(), translation -> translation.argument().offlinePlayer());

            return;
        }

        this.replies.put(target.getUniqueId(), sender.getUniqueId());
        this.replies.put(sender.getUniqueId(), target.getUniqueId());


        CompletableFuture.runAsync(() -> {
            PrivateChatEvent event = new PrivateChatEvent(sender.getUniqueId(), target.getUniqueId(), message);
            this.eventCaller.callEvent(event);
            this.presenter.onPrivate(new PrivateMessage(sender, target, event.getContent()));
        });
    }

    void reply(User sender, String message) {
        UUID uuid = this.replies.getIfPresent(sender.getUniqueId());

        if (uuid == null) {
            this.noticeService.player(sender.getUniqueId(), translation -> translation.privateChat().noReply());

            return;
        }

        Optional<User> targetOption = this.userManager.getUser(uuid);

        if (targetOption.isEmpty()) {
            this.noticeService.player(sender.getUniqueId(), translation -> translation.argument().offlinePlayer());

            return;
        }

        User target = targetOption.get();

        this.privateMessage(sender, target, message);
    }

    @Override
    public void reply(Player sender, String message) {
        this.reply(this.userManager.getOrCreate(sender.getUniqueId(), sender.getName()), message);
    }

    @Override
    public void privateMessage(Player sender, Player target, String message) {
        User user = this.userManager.getOrCreate(target.getUniqueId(), target.getName());
        this.privateMessage(this.userManager.getOrCreate(sender.getUniqueId(), sender.getName()), user, message);
    }
}
