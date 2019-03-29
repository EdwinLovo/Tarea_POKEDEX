package com.example.acer.pokedex;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.acer.pokedex.models.Pokemon;

import java.util.ArrayList;

public abstract class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> dataset;
    private Context context;

    public ListaPokemonAdapter(Context context){
        this.context=context;
        dataset=new ArrayList<>();
    }

    public abstract void startIntent(String text, String srcImage);

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+p.getNumber()+".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);

        holder.linearPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //holder.fotoImageView.setImageResource(R.drawable.charmander);
                String text = holder.nombreTextView.getText().toString();
                String srcImage = "";
                startIntent(text,srcImage);

            }
        });

    }

    @Override
    public int getItemCount(){
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoImageView;
        private TextView nombreTextView;
        private LinearLayout linearPokemon;

        public ViewHolder(View itemView){
            super(itemView);
            fotoImageView = itemView.findViewById(R.id.ImageViewPoke);
            nombreTextView = itemView.findViewById(R.id.textViewPoke);
            linearPokemon = itemView.findViewById(R.id.Linear_pokemon);
        }
    }
}
