package br.com.neresfelip.gfxconsultoria.data;

import android.util.Log;

import java.util.List;

import br.com.neresfelip.gfxconsultoria.data.remote.ListPokemonResponse;
import br.com.neresfelip.gfxconsultoria.data.remote.PokemonAPI;
import br.com.neresfelip.gfxconsultoria.data.remote.PokemonResponse;
import br.com.neresfelip.gfxconsultoria.data.remote.RepositoryCallback;
import br.com.neresfelip.gfxconsultoria.data.remote.RetrofitClient;
import br.com.neresfelip.gfxconsultoria.domain.mapper.PokemonMapper;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;
import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonAPI api;

    public PokemonRepositoryImpl() {

        Retrofit retrofit = RetrofitClient.getInstance();
        api = retrofit.create(PokemonAPI.class);
    }

    @Override
    public void getPokemons(RepositoryCallback<List<Pokemon>> callback) {
        api.getPokemons().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ListPokemonResponse> call, Response<ListPokemonResponse> response) {
                if (response.isSuccessful()) {

                    List<Pokemon> list = PokemonMapper.map(response.body());
                    callback.onSuccess(list);

                } else {
                    callback.onError(new Exception("Erro HTTP: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<ListPokemonResponse> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

}
