package br.com.neresfelip.gfxconsultoria.ui.rv_adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import br.com.neresfelip.gfxconsultoria.databinding.PokemonItemBinding;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    private final PokemonItemBinding binding;

    public PokemonViewHolder(@NonNull PokemonItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void set(Pokemon item) {

        Picasso.get()
                .load(item.getUrlImage())
                .into(binding.pokemonImage);

        binding.pokemonName.setText(item.getName());
        binding.pokemonId.setText("#"+item.getId());
    }

}
