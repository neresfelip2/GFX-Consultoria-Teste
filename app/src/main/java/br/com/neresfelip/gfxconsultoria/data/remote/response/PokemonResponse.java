package br.com.neresfelip.gfxconsultoria.data.remote.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class PokemonResponse {

    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

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
