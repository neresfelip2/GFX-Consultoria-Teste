package br.com.neresfelip.gfxconsultoria.domain.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.neresfelip.gfxconsultoria.BuildConfig;
import br.com.neresfelip.gfxconsultoria.data.remote.response.ListPokemonResponse;
import br.com.neresfelip.gfxconsultoria.data.remote.response.PokemonResponse;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class PokemonMapper {

    public static List<Pokemon> map(ListPokemonResponse response) {
        List<Pokemon> pokemons = new ArrayList<>();

        if (response == null || response.getList() == null) {
            return pokemons;
        }

        for (PokemonResponse item : response.getList()) {
            pokemons.add(new Pokemon(
                    item.getName(),
                    BuildConfig.API_URL_IMG + extractPokemonId(item.getUrl()) + ".png"
            ));
        }

        return pokemons;
    }

    public static int extractPokemonId(String url) {
        Pattern pattern = Pattern.compile(".*/pokemon/(\\d+)/?");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return -1;
    }

}
