package br.com.neresfelip.gfxconsultoria.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonAPI {

    @GET("pokemon?limit=100000&offset=0")
    Call<ListPokemonResponse> getPokemons();
}

