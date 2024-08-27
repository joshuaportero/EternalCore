package com.eternalcode.core.feature.language.config;

import com.eternalcode.core.configuration.ReloadableConfig;
import com.eternalcode.core.injector.annotations.component.ConfigurationFile;
import com.eternalcode.core.feature.language.Language;
import com.google.common.collect.ImmutableList;
import net.dzikoysk.cdn.entity.Contextual;
import net.dzikoysk.cdn.entity.Description;
import net.dzikoysk.cdn.source.Resource;
import net.dzikoysk.cdn.source.Source;
import org.bukkit.Material;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ConfigurationFile
public class LanguageConfiguration implements ReloadableConfig {

    @Description(" ")
    public Language defaultLanguage = Language.EN;
    public List<Language> languages = Arrays.asList(Language.EN, Language.ES);

    @Description(" ")
    public LanguageSelector languageSelector = new LanguageSelector();

    @Contextual
    public static class LanguageSelector  {
        @Description("# Name of inventory")
        public String title = "&6Select a language";

        @Description({ " ", "# Size of inventory" })
        public int rows = 5;

        @Description({ " ", "# Border settings" })
        public Border border = new Border();

        @Contextual
        public static class Border {
            public boolean fill = true;

            @Description(" ")
            public Material material = Material.GRAY_STAINED_GLASS_PANE;

            @Description({ " ", "# TOP, BOTTOM, BORDER, ALL" })
            public Border.FillType type = Border.FillType.BORDER;

            @Description({ " ", "# Name (If you don't want name just set \"\")" })
            public String name = " ";

            @Description({ " ", "# Lore (If you don't want lore just set [])" })
            public List<String> lore = Collections.emptyList();

            public enum FillType {
                TOP, BOTTOM, BORDER, ALL
            }
        }

        @Description({ " ", "# List of languages" })
        public List<LanguageConfigItem> languageConfigItemMap = new ImmutableList.Builder<LanguageConfigItem>()
            .add(new LanguageConfigItem(
                "&c&lEnglish",
                Collections.singletonList("&7▪ <gradient:#66ff99:#00ffff>Click to change language!"),
                Material.PLAYER_HEAD,
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODc5ZDk5ZDljNDY0NzRlMjcxM2E3ZTg0YTk1ZTRjZTdlOGZmOGVhNGQxNjQ0MTNhNTkyZTQ0MzVkMmM2ZjlkYyJ9fX0",
                false,
                20,
                Collections.emptyList(),
                Language.EN)
            )
            .add(new LanguageConfigItem(
                "&c&lAuto",
                Collections.singletonList("&7▪ <gradient:#66ff99:#00ffff>Click to change language!"),
                Material.REPEATER,
                "none",
                false,
                22,
                Collections.emptyList(),
                Language.DEFAULT)
            )
            .add(new LanguageConfigItem(
                "&6&lEspañol",
                Collections.singletonList("&7▪ <gradient:#66ff99:#00ffff>Haz clic para cambiar el idioma!"),
                Material.PLAYER_HEAD,
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTNjNzlhNzhkZTVjYmVkYmQyMjEwMzZhNjRmNGM2ZWMzOTExOTYwZGUxNzZiZGJlNDliNGQ1MDFmNDFkZjMifX19",
                false,
                24,
                Collections.emptyList(),
                Language.ES)
            )
            .build();
    }

    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "language.yml");
    }

}
