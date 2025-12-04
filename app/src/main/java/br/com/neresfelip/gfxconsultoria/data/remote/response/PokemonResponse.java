package br.com.neresfelip.gfxconsultoria.data.remote.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class PokemonResponse {

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public PokemonResponse(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @NonNull
    @Override
    public String toString() {
        return "PokemonResponse{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
