package br.com.neresfelip.gfxconsultoria.domain.repository;

import java.util.List;

import br.com.neresfelip.gfxconsultoria.data.repository.callback.RepositoryCallback;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public interface PokemonRepository {
    void getPokemons(boolean onlyEven, RepositoryCallback<List<Pokemon>> callback);
}
