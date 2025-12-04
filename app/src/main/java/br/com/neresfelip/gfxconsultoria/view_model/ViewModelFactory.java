package br.com.neresfelip.gfxconsultoria.view_model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final PokemonRepository repository;

    public ViewModelFactory(PokemonRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

