package com.eternalcode.core.feature.privatechat;

import com.eternalcode.core.injector.annotations.Inject;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.RootCommand;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.join.Join;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.entity.Player;

@RootCommand
class PrivateChatCommands {

    private final PrivateChatService privateChatService;

    @Inject
    PrivateChatCommands(PrivateChatService privateChatService) {
        this.privateChatService = privateChatService;
    }

    @Execute(name = "msg", aliases = {"message", "m", "whisper", "tell", "t"})
    @Permission("eternalcore.msg")
    void execute(@Context Player sender, @Arg Player target, @Join String message) {
        this.privateChatService.privateMessage(sender, target, message);
    }

    @Execute(name = "reply", aliases = {"r"})
    @Permission("eternalcore.reply")
    void execute(@Context Player sender, @Join String message) {
        this.privateChatService.reply(sender, message);
    }
}
