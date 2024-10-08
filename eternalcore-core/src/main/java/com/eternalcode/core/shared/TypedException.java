package com.eternalcode.core.shared;

import lombok.Getter;

@Getter
public class TypedException extends RuntimeException {

    private final Class<?> type;

    public TypedException(Class<?> type) {
        this.type = type;
    }

    public TypedException(String message, Class<?> type) {
        super(message);
        this.type = type;
    }

    public TypedException(String message, Throwable cause, Class<?> type) {
        super(message, cause);
        this.type = type;
    }

    public TypedException(Throwable cause, Class<?> type) {
        super(cause);
        this.type = type;
    }
}
