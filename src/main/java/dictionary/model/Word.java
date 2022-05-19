package dictionary.model;

public class Word implements Cloneable {
    private Long id;
    private String eng;
    private String vie;


    public Word() {
    }

    public Word(String eng, String vie) {
        this.eng = eng;
        this.vie = vie;
    }

    public Word(Long id, String eng, String vie) {
        this.id = id;
        this.eng = eng;
        this.vie = vie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getVie() {
        return vie;
    }

    public void setVie(String vie) {
        this.vie = vie;
    }

    @Override
    public Word clone() {
        Word word = new Word();
        word.setId(id);
        word.setEng(eng);
        word.setVie(vie);
        return word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", eng='" + eng + '\'' +
                ", vie='" + vie + '\'' +
                '}';
    }
}
