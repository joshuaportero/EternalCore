package com.eternalcode.core.notice;

import com.eternalcode.core.injector.annotations.Bean;
import com.eternalcode.core.injector.annotations.component.BeanSetup;
import com.eternalcode.multification.bukkit.notice.resolver.sound.SoundBukkitResolver;
import com.eternalcode.multification.notice.resolver.NoticeResolverDefaults;
import com.eternalcode.multification.notice.resolver.NoticeResolverRegistry;

@BeanSetup
public class EternalCoreNoticeBukkitResolver {

    @Bean
    public NoticeResolverRegistry resolverRegistry() {
        return NoticeResolverDefaults.createRegistry()
            .registerResolver(new SoundBukkitResolver());
    }
}
