package br.com.neresfelip.gfxconsultoria.view_model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Objects;

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
        loadPokemons(false);
    }

    public void loadPokemons(boolean onlyEven) {
        repository.getPokemons(onlyEven, new RepositoryCallback<>() {
            @Override
            public void onSuccess(List<Pokemon> data) {
                _pokemonList.postValue(data);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(MainViewModel.class.getName(), Objects.requireNonNull(t.getMessage()));
            }
        });
    }

}

