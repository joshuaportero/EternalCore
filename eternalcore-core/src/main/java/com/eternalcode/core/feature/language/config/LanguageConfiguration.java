package com.eternalcode.core.feature.language.config;

import com.eternalcode.core.configuration.ReloadableConfig;
import com.eternalcode.core.feature.language.Language;
import com.eternalcode.core.injector.annotations.component.ConfigurationFile;
import net.dzikoysk.cdn.entity.Description;
import net.dzikoysk.cdn.source.Resource;
import net.dzikoysk.cdn.source.Source;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@ConfigurationFile
public class LanguageConfiguration implements ReloadableConfig {

    @Description(" ")
    public Language defaultLanguage = Language.ES;
    public List<Language> languages = Arrays.asList(Language.EN, Language.ES);

    @Override
    public Resource resource(File folder) {
        return Source.of(folder, "language.yml");
    }

}
