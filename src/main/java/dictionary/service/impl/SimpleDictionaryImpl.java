package dictionary.service.impl;

import dictionary.model.Word;
import dictionary.service.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SimpleDictionaryImpl implements Dictionary {
    private static List<Word> words;
    private static long autoIncreaseId = 0;

    static {
        words = asList(
                new Word(autoIncreaseId++, "Book", "Sach"),
                new Word(autoIncreaseId++, "Hello", "Chao"),
                new Word(autoIncreaseId++, "Cake", "Banh"),
                new Word(autoIncreaseId++, "Meat", "Thit")
        );
    }

    @Override
    public List<Word> findAll() {
        return new ArrayList<>(words);
    }

    @Override
    public Word findOne(Long id) {
        return words.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Word translate(String eng) {
        return words.stream()
                .filter(c -> c.getEng().equals(eng))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Word save(Word word) {
        return word.getId() == null ? persist(word) : merge(word);
    }

    @Override
    public List<Word> save(List<Word> Words) {
        return words.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return words.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public List<Word> findAll(List<Long> ids) {
        return ids.stream()
                .map(this::findOne)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return words.size();
    }

    @Override
    public void delete(Long id) {
        words.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public void delete(Word word) {
        delete(word.getId());
    }

    @Override
    public void delete(List<Word> words) {
        words.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        words = new ArrayList<>();
    }

    private Word persist(Word word) {
        Word clone = word.clone();
        clone.setId(autoIncreaseId++);
        words.add(clone);
        return clone;
    }

    private Word merge(Word word) {
        Word origin = findOne(word.getId());
        origin.setEng(word.getEng());
        origin.setVie(word.getVie());
        return origin;
    }
}
