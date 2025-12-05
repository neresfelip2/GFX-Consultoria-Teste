package br.com.neresfelip.gfxconsultoria.data.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class PokemonRepositoryImplTest {

    private PokemonRepositoryImpl repository;

    @Before
    public void setup() {
        repository = new PokemonRepositoryImpl(null);
    }

    // verifica se os pokemons são filtrados corretamente
    @Test
    public void filterEven_shouldReturnOnlyEvenPokemons() {

        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(1, "bulbasaur", ""),
                new Pokemon(2, "ivysaur", ""),
                new Pokemon(3, "venusaur", ""),
                new Pokemon(4, "charmander", "")
        );

        List<Pokemon> filtered = repository.filterEven(pokemons);

        assertEquals(2, filtered.size());
        assertEquals(2, filtered.get(0).getId());
        assertEquals(4, filtered.get(1).getId());
    }

    // verifica se a lista é vazia quando não há pokemons pares
    @Test
    public void filterEven_shouldReturnEmptyListWhenNoEven() {

        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(1, "bulbasaur", ""),
                new Pokemon(3, "venusaur", "")
        );

        List<Pokemon> filtered = repository.filterEven(pokemons);

        assertEquals(0, filtered.size());
    }

    // verifica se todos os pokemons são retornados quando todos são pares
    @Test
    public void filterEven_shouldReturnAllWhenAllEven() {

        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(2, "ivysaur", ""),
                new Pokemon(4, "charmander", "")
        );

        List<Pokemon> filtered = repository.filterEven(pokemons);

        assertEquals(2, filtered.size());
    }
}

