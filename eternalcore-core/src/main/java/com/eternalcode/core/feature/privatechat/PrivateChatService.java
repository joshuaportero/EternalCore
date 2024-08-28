package com.eternalcode.core.feature.privatechat;

import org.bukkit.entity.Player;

public interface PrivateChatService {

    void reply(Player sender, String message);

    void privateMessage(Player sender, Player target, String message);
}
