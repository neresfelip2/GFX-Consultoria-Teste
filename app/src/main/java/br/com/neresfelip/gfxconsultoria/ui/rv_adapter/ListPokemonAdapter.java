package br.com.neresfelip.gfxconsultoria.ui.rv_adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.neresfelip.gfxconsultoria.databinding.PokemonItemBinding;
import br.com.neresfelip.gfxconsultoria.domain.model.Pokemon;

public class ListPokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    private final List<Pokemon> list;

    public ListPokemonAdapter(List<Pokemon> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PokemonItemBinding binding = PokemonItemBinding.inflate(inflater, parent, false);

        return new PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon item = list.get(position);
        holder.set(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

