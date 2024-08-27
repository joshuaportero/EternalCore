package com.eternalcode.core.feature.language;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public record Language(@Getter String lang, List<String> aliases) {

    public static final Language ES = new Language("es", List.of("es_mx"));
    public static final Language EN = new Language("en", List.of("en_en"));
    public static final Language DEFAULT = Language.fromLocale(Locale.ROOT);

    public Language(String lang, List<String> aliases) {
        this.lang = lang;
        this.aliases = new ArrayList<>(aliases);
    }

    @Override
    public List<String> aliases() {
        return Collections.unmodifiableList(this.aliases);
    }

    public boolean isEquals(Language other) {
        if (this.lang.equals(other.lang)) {
            return true;
        }

        for (String alias : this.aliases) {
            if (alias.equals(other.lang)) {
                return true;
            }

            for (String otherAlias : other.aliases) {
                if (alias.equals(otherAlias)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Language language)) {
            return false;
        }

        return this.lang.equals(language.lang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lang);
    }

    public static Language fromLocale(Locale locale) {
        return new Language(locale.getLanguage(), List.of());
    }

    public Locale toLocale() {
        return new Locale(this.lang);
    }

}
