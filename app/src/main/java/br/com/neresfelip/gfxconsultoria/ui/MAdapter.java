package br.com.neresfelip.gfxconsultoria.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.neresfelip.gfxconsultoria.databinding.PokemonItemBinding;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MViewHolder> {

    private final List<Pokemon> list;

    public MAdapter(List<Pokemon> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PokemonItemBinding binding = PokemonItemBinding.inflate(inflater, parent, false);

        return new MViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {
        Pokemon item = list.get(position);
        holder.set(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MViewHolder extends RecyclerView.ViewHolder {

        private final PokemonItemBinding binding;

        public MViewHolder(@NonNull PokemonItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void set(Pokemon item) {

            Picasso.get()
                    .load(item.getUrlImage())
                    .into(binding.pokemonImage);

            binding.pokemonName.setText(item.getTitle());
        }

    }
}

