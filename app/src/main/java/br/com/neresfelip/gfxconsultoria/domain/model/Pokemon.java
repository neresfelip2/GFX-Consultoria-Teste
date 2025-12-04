package br.com.neresfelip.gfxconsultoria.domain.model;

public class Pokemon {
    private String title;
    private String urlImage;

    public Pokemon(String title, String urlImage) {
        this.title = title;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
