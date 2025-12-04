package br.com.neresfelip.gfxconsultoria.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import br.com.neresfelip.gfxconsultoria.data.repository.PokemonRepositoryImpl;
import br.com.neresfelip.gfxconsultoria.domain.repository.PokemonRepository;
import br.com.neresfelip.gfxconsultoria.view_model.MainViewModel;
import br.com.neresfelip.gfxconsultoria.R;
import br.com.neresfelip.gfxconsultoria.databinding.ActivityMainBinding;
import br.com.neresfelip.gfxconsultoria.view_model.ViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Aqui, o ideal era usar Injeção de Dependência (Dagger/Hilt). Estou deixando desse jeito apenas porque o tempo era curto pra implementar ela
        // Tenho outros projetos no meu github onde faço uso dela e evito esse trecho aqui.
        // Em um projeto real eu sempre faço o uso dela
        PokemonRepository repository = new PokemonRepositoryImpl();
        ViewModelFactory factory = new ViewModelFactory(repository);
        viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        viewModel.pokemonList
                .observe(this, movies -> binding.rvMain.setAdapter(new RVListPokemonAdapter(movies)));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}