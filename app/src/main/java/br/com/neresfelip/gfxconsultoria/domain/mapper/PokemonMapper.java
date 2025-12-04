package br.com.neresfelip.gfxconsultoria.domain.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.neresfelip.gfxconsultoria.data.remote.ListPokemonResponse;
import br.com.neresfelip.gfxconsultoria.data.remote.PokemonResponse;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class PokemonMapper {

    public static List<Pokemon> map(ListPokemonResponse response) {
        List<Pokemon> pokemons = new ArrayList<>();

        if (response == null || response.getList() == null) {
            return pokemons; // lista vazia
        }

        for (PokemonResponse item : response.getList()) {
            pokemons.add(new Pokemon(
                    item.getName(),
                    item.getUrl()
            ));
        }

        return pokemons;
    }
}
