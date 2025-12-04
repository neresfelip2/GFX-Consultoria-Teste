package br.com.neresfelip.gfxconsultoria.view_model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import br.com.neresfelip.gfxconsultoria.data.PokemonRepositoryImpl;
import br.com.neresfelip.gfxconsultoria.data.remote.RepositoryCallback;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;
import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;

public class MainViewModel extends ViewModel {

    PokemonRepository repository = new PokemonRepositoryImpl();

    private final MutableLiveData<List<Pokemon>> _pokemonList = new MutableLiveData<>();
    public LiveData<List<Pokemon>> pokemonList = _pokemonList;

    public MainViewModel() {
        loadPokemons();
    }

    private void loadPokemons() {

        repository.getPokemons(new RepositoryCallback<>() {

            @Override
            public void onSuccess(List<Pokemon> data) {
                _pokemonList.postValue(data);
            }

            @Override
            public void onError(Throwable t) {
                Log.i("teste", t.getMessage());
            }
        });

    }
}
