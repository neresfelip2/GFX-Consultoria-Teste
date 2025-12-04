package br.com.neresfelip.gfxconsultoria.domain.model;

public class Pokemon {
    private String title;
    private String urlPoster;

    public Pokemon(String title, String urlPoster) {
        this.title = title;
        this.urlPoster = urlPoster;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "title='" + title + '\'' +
                ", urlPoster='" + urlPoster + '\'' +
                '}';
    }
}
