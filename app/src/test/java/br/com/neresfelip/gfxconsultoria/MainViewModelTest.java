package br.com.neresfelip.gfxconsultoria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import br.com.neresfelip.gfxconsultoria.data.repository.callback.RepositoryCallback;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;
import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;
import br.com.neresfelip.gfxconsultoria.view_model.MainViewModel;

@RunWith(MockitoJUnitRunner.class)
public class MainViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    PokemonRepository repository;

    private MainViewModel viewModel;

    @Before
    public void setup() {
        viewModel = new MainViewModel(repository);
    }

    @Test
    public void testLoadPokemons_success() {

        // DADO
        List<Pokemon> fakeList = Arrays.asList(
                new Pokemon("bulbasaur", "1"),
                new Pokemon("charmander", "4")
        );

        // QUANDO o repository for chamado, simula o retorno
        Mockito.doAnswer(invocation -> {
            RepositoryCallback<List<Pokemon>> callback = invocation.getArgument(0);
            callback.onSuccess(fakeList);
            return null;
        }).when(repository).getPokemons(Mockito.any());

        // AÇÃO: chamar loadPokemons()
        viewModel.loadPokemonsForTest();

        // ENTÃO: LiveData contém a lista fake
        List<Pokemon> result = viewModel.pokemonList.getValue();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("bulbasaur", result.get(0).getTitle());
    }
}

