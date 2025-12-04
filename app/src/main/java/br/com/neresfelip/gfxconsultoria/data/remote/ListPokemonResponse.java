package br.com.neresfelip.gfxconsultoria.data.remote;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListPokemonResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<PokemonResponse> list;

    public int getCount() {
        return count;
    }

    public List<PokemonResponse> getList() {
        return list;
    }

    @NonNull
    @Override
    public String toString() {
        return "ListPokemonResponse{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }
}
