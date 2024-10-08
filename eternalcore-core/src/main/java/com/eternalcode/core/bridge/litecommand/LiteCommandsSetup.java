package com.eternalcode.core.bridge.litecommand;

import com.eternalcode.core.injector.annotations.Bean;
import com.eternalcode.core.injector.annotations.component.BeanSetup;
import com.eternalcode.core.injector.bean.BeanFactory;
import com.eternalcode.core.publish.Subscribe;
import com.eternalcode.core.publish.Subscriber;
import com.eternalcode.core.publish.event.EternalInitializeEvent;
import com.eternalcode.core.publish.event.EternalShutdownEvent;
import dev.rollczi.litecommands.LiteCommands;
import dev.rollczi.litecommands.LiteCommandsBuilder;
import dev.rollczi.litecommands.adventure.LiteAdventureExtension;
import dev.rollczi.litecommands.annotations.LiteCommandsAnnotations;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

@BeanSetup
class LiteCommandsSetup implements Subscriber {

    @Bean
    public LiteCommandsBuilder<CommandSender, ?, ?> liteCommandsBuilder(
        Plugin plugin,
        Server server,
        MiniMessage miniMessage,
        LiteCommandsAnnotations<CommandSender> liteCommandsAnnotations
    ) {
        return LiteBukkitFactory.builder("eternalcore", plugin, server)
            .commands(liteCommandsAnnotations)
            .extension(new LiteAdventureExtension<>(), config -> config
                .serializer(miniMessage)
            );
    }

    @Bean
    public LiteCommandsAnnotations<CommandSender> liteCommandsAnnotations() {
        return LiteCommandsAnnotations.create();
    }

    @Subscribe(EternalInitializeEvent.class)
    public void onEnable(BeanFactory beanFactory, LiteCommandsBuilder<CommandSender, ?, ?> liteCommandsBuilder) {
        LiteCommands<CommandSender> register = liteCommandsBuilder.build();
        beanFactory.addCandidate(LiteCommands.class, () -> register);
    }

    @Subscribe(EternalShutdownEvent.class)
    public void onShutdown(LiteCommands<CommandSender> liteCommands) {
        liteCommands.unregister();
    }

}
