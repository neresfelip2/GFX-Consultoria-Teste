package br.com.neresfelip.gfxconsultoria.view_model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import br.com.neresfelip.gfxconsultoria.data.repository.callback.RepositoryCallback;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;
import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final PokemonRepository repository;

    private final MutableLiveData<List<Pokemon>> _pokemonList = new MutableLiveData<>();
    public LiveData<List<Pokemon>> pokemonList = _pokemonList;

    @Inject
    public MainViewModel(PokemonRepository repository) {
        this.repository = repository;
        loadPokemons();
    }

    public void loadPokemons() {

        /** aqui é a chamada para a api
        não estou fazendo nenhum tipo de tratamento do status da chamada (carregando, sucesso e erro) apenas para mostrar o funcionamento do livedata diretamente
        mas em projetos reais, eu costumo criar um wrapper para tratar estes status da chamada e utilizo ele no LiveData */

        repository.getPokemons(new RepositoryCallback<>() {

            @Override
            public void onSuccess(List<Pokemon> data) {
                _pokemonList.postValue(data);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(MainViewModel.class.getName(), t.getMessage());
            }
        });

    }
}

