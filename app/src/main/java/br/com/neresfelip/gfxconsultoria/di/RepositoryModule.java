package br.com.neresfelip.gfxconsultoria.di;

import javax.inject.Singleton;

import br.com.neresfelip.gfxconsultoria.data.remote.PokemonAPI;
import br.com.neresfelip.gfxconsultoria.data.repository.PokemonRepositoryImpl;
import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;
import br.com.neresfelip.gfxconsultoria.domain.helper.PokemonHelper;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public PokemonRepository providePokemonRepository(PokemonAPI api) {
        return new PokemonRepositoryImpl(api);
    }
}
