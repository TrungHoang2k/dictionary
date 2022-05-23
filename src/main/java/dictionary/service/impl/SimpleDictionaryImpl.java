package dictionary.service.impl;

import dictionary.model.Word;
import dictionary.service.Dictionary;
import java.util.List;
import static java.util.Arrays.asList;

public class SimpleDictionaryImpl implements Dictionary {
    private static List<Word> words;

    static {
        words = asList(
                new Word("Book", "Sach"),
                new Word("Hello", "Chao"),
                new Word("Cake", "Banh"),
                new Word("Meat", "Thit")
        );
    }

    @Override
    public Word translate(String eng) {
        return words.stream()
                .filter(c -> c.getEng().equals(eng))
                .findFirst()
                .orElse(null);
    }
}
