package dictionary.service;

import dictionary.model.Word;

public interface Dictionary {
    Word translate(String end);
}

