package br.com.neresfelip.gfxconsultoria.domain.repository;

import java.util.List;

import br.com.neresfelip.gfxconsultoria.data.remote.RepositoryCallback;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public interface PokemonRepository {
    void getPokemons(RepositoryCallback<List<Pokemon>> callback);
}
