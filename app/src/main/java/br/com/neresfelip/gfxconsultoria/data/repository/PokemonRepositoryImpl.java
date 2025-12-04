package br.com.neresfelip.gfxconsultoria.data.repository;

import android.os.AsyncTask;

import java.util.List;

import javax.inject.Inject;

import br.com.neresfelip.gfxconsultoria.data.remote.response.ListPokemonResponse;
import br.com.neresfelip.gfxconsultoria.data.remote.PokemonAPI;
import br.com.neresfelip.gfxconsultoria.data.repository.callback.RepositoryCallback;
import br.com.neresfelip.gfxconsultoria.domain.mapper.PokemonMapper;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;
import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;
import retrofit2.Response;

public class PokemonRepositoryImpl implements PokemonRepository {

    private final PokemonAPI pokeAPI;

    public PokemonRepositoryImpl(PokemonAPI pokeAPI) {
        this.pokeAPI = pokeAPI;
    }

    @Override
    public void getPokemons(RepositoryCallback<List<Pokemon>> callback) {

        /**
         * Este seria um exemplo de uso do AsyncTask (deprecated) solicitado na tarefa
         * */

        new AsyncTask<Void, Void, List<Pokemon>>() {

            private Throwable error;

            @Override
            protected List<Pokemon> doInBackground(Void... voids) {
                try {
                    Response<ListPokemonResponse> response = pokeAPI.getPokemons().execute();
                    if (response.isSuccessful()) {
                        return PokemonMapper.map(response.body());
                    } else {
                        error = new Exception("Erro HTTP: " + response.code());
                        return null;
                    }
                } catch (Throwable t) {
                    error = t;
                    return null;
                }
            }

            @Override
            protected void onPostExecute(List<Pokemon> pokemons) {
                if (error != null) {
                    callback.onError(error);
                } else {
                    callback.onSuccess(pokemons);
                }
            }
        }.execute();


        /** O trecho comentado abaixo é a melhor forma do uso do Retrofit atualmente (utilizando enqueue, que por si só já faz uma chamada assincrona para a API) */

        /*pokeAPI.getPokemons().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<ListPokemonResponse> call, @NonNull Response<ListPokemonResponse> response) {
                if (response.isSuccessful()) {
                    List<Pokemon> list = PokemonMapper.map(response.body());
                    callback.onSuccess(list);
                } else {
                    callback.onError(new Exception("Erro HTTP: " + response.code()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ListPokemonResponse> call, @NonNull Throwable t) {
                callback.onError(t);
            }
        });*/

    }

}
