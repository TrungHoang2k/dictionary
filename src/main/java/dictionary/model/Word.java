package dictionary.model;

public class Word{
    private String eng;
    private String vie;

    public Word() {
    }

    public Word(String eng, String vie) {
        this.eng = eng;
        this.vie = vie;
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
}

