package br.com.neresfelip.gfxconsultoria.domain.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import br.com.neresfelip.gfxconsultoria.BuildConfig;
import br.com.neresfelip.gfxconsultoria.data.remote.response.ListPokemonResponse;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class PokemonMapper {

    public static List<Pokemon> map(ListPokemonResponse response) {
        if (response == null || response.getList() == null) {
            return Collections.emptyList();
        }

        return response.getList().stream()
                .map(pokemonResponse -> {
                    int pokemonId = extractPokemonId(pokemonResponse.getUrl());
                    return new Pokemon(
                            pokemonId,
                            pokemonResponse.getName(),
                            BuildConfig.API_URL_IMG + pokemonId + ".png"
                    );
                })
                .collect(Collectors.toList());
    }

    public static int extractPokemonId(String url) {
        Pattern pattern = Pattern.compile(".*/pokemon/(\\d+)/?");
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return Integer.parseInt(Objects.requireNonNull(matcher.group(1)));
        }
        return -1;
    }

}
