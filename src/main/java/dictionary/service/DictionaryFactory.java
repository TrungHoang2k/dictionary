package dictionary.service;

import dictionary.service.impl.SimpleDictionaryImpl;

public class DictionaryFactory {
    private static Dictionary singleton;

    public static synchronized Dictionary getInstance() {
        if (singleton == null) {
            singleton = new SimpleDictionaryImpl();
        }
        return singleton;
    }
}

