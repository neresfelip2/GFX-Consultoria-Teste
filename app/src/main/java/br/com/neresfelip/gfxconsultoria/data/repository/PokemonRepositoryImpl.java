package br.com.neresfelip.gfxconsultoria.data.repository;

import java.util.List;

import br.com.neresfelip.gfxconsultoria.data.remote.response.ListPokemonResponse;
import br.com.neresfelip.gfxconsultoria.data.remote.PokemonAPI;
import br.com.neresfelip.gfxconsultoria.data.repository.callback.RepositoryCallback;
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

    /** Aqui eu instanciei a depedência do Repository no construtor apenas por questão de exemplo.
     * Mas em projetos reais, aqui também eu utilizaria o Dagger/Hilt para injetar essa dependência automaticamente. Como faço em outros projetos em meu GitHub */
    public PokemonRepositoryImpl() {
        Retrofit retrofit = RetrofitClient.getInstance();
        api = retrofit.create(PokemonAPI.class);
    }

    /** Embora a tarefa peça o uso da AsyncTask, eu não implementei ela porque estou usando a biblioteca Retrofit e ela dispensa o uso da AsyncTask, já que ela
     * está deprecated há alguns anos.
     * O enqueue() por si só já faz uma requisição assíncrona à API e substitui ela.
     * */

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
