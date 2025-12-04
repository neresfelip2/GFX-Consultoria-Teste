package br.com.neresfelip.gfxconsultoria.di;

import javax.inject.Singleton;

import br.com.neresfelip.gfxconsultoria.BuildConfig;
import br.com.neresfelip.gfxconsultoria.data.remote.PokemonAPI;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public PokemonAPI providePokemonAPI(Retrofit retrofit) {
        return retrofit.create(PokemonAPI.class);
    }
}
