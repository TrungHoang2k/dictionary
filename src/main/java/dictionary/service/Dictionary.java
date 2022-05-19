package dictionary.service;

import dictionary.model.Word;

import java.util.List;

public interface Dictionary {
    List<Word> findAll();

    Word findOne(Long id);

    Word translate(String end);

    Word save(Word customer);

    List<Word> save(List<Word> words);

    boolean exists(Long id);

    List<Word> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Word Word);

    void delete(List<Word> words);

    void deleteAll();
}
