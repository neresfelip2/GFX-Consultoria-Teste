package br.com.neresfelip.gfxconsultoria.domain.helper;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.stream.Collectors;

import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class PokemonHelper {

    // Regra que filtra os Pokemons com ID pares
    public static List<Pokemon> filterEven(@NonNull List<Pokemon> list, boolean onlyEven) {
        return onlyEven ? list.stream()
                .filter(p -> p.getId() % 2 == 0)
                .collect(Collectors.toList()) : list;
    }

}
