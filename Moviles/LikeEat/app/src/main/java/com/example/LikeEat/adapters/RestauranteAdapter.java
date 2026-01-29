package com.example.LikeEat.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LikeEat.R;
import com.example.LikeEat.Restaurant;
import com.example.LikeEat.ui.feed.OnCardActionListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RestauranteAdapter
        extends RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder> {

    private List<Restaurant> restaurantes;
    private OnCardActionListener Cardlistener;

    public RestauranteAdapter(List<Restaurant> restaurantes, OnCardActionListener Cardlistener) {
        this.restaurantes = restaurantes;
        this.Cardlistener = Cardlistener;
    }

    @NonNull
    @Override
    public RestauranteViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant, parent, false);

        return new RestauranteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull RestauranteViewHolder holder, int position) {

        holder.bind(restaurantes.get(position));
        holder.setUpListeners(Cardlistener);
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public void setRestaurantes(List<Restaurant> restaurantes) {
        this.restaurantes = restaurantes;
        notifyDataSetChanged();
    }

    public Restaurant getItem(int position) {
        return restaurantes.get(position);
    }


    static class RestauranteViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombre;
        private ImageView ivImagen;
        private CardView cvCategory1, cvCategory2, cvCategory3;
        private TextView category1, category2, category3;
        private FloatingActionButton btnLike, btnRefresh, btnDislike;


        public RestauranteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvRestaurantName);
            ivImagen = itemView.findViewById(R.id.restaurantImage);
            category1 = itemView.findViewById(R.id.tvCategory1);
            category2 = itemView.findViewById(R.id.tvCategory2);
            category3 = itemView.findViewById(R.id.tvCategory3);
            cvCategory1 = itemView.findViewById(R.id.cvCategory1);
            cvCategory2 = itemView.findViewById(R.id.cvCategory2);
            cvCategory3 = itemView.findViewById(R.id.cvCategory3);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnRefresh = itemView.findViewById(R.id.btnRefresh);
            btnDislike = itemView.findViewById(R.id.btnDislike);

        }

        public void setUpListeners(OnCardActionListener listener) {
            btnLike.setOnClickListener(v -> listener.onLike());
            btnRefresh.setOnClickListener(v -> listener.onRefresh());
            btnDislike.setOnClickListener(v -> listener.onDislike());
        }

        public void bind(Restaurant restaurante) {
            tvNombre.setText(restaurante.getName());
            ivImagen.setImageResource(restaurante.getImageResId());
            category1.setText(restaurante.getCategory1());
            category2.setText(restaurante.getCategory2());
            category3.setText(restaurante.getCategory3());
            cvCategory1.setVisibility(category1.getText().equals("") ? View.INVISIBLE : View.VISIBLE);
            cvCategory2.setVisibility(category2.getText().equals("") ? View.INVISIBLE : View.VISIBLE);
            cvCategory3.setVisibility(category3.getText().equals("") ? View.INVISIBLE : View.VISIBLE);


        }

    }
}
