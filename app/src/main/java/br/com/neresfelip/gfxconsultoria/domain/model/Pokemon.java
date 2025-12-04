package br.com.neresfelip.gfxconsultoria.domain.model;

public class Pokemon {

    private final int id;
    private final String name;
    private final String urlImage;

    public Pokemon(int id, String name, String urlImage) {
        this.id = id;
        this.name = name;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
