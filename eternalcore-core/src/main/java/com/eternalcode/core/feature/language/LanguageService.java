package com.eternalcode.core.feature.language;

import org.bukkit.entity.Player;

import java.util.Locale;

public interface LanguageService {

    Locale getPlayerLanguage(Player player);

    void setPlayerLanguage(Player player, Locale locale);
}
