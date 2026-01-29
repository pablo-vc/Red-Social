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

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.RestaurantViewHolder> {

    private ArrayList<Restaurant> restaurantList;

    public FeedAdapter(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }


    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.name.setText(restaurant.getName());
        holder.image.setImageResource(restaurant.getImageResId());
        holder.category1.setText(restaurant.getCategory1());
        holder.category2.setText(restaurant.getCategory2());
        holder.category3.setText(restaurant.getCategory3());
        holder.cvCategory1.setVisibility(holder.category1.getText().equals("") ? View.INVISIBLE : View.VISIBLE);
        holder.cvCategory2.setVisibility(holder.category2.getText().equals("") ? View.INVISIBLE : View.VISIBLE);
        holder.cvCategory3.setVisibility(holder.category3.getText().equals("") ? View.INVISIBLE : View.VISIBLE);
        // Reset obligatorio
        holder.itemView.setRotation(0f);
        holder.itemView.setAlpha(1f);
    }


    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView category1,category2,category3;
        CardView cvCategory1, cvCategory2, cvCategory3;


        public RestaurantViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.restaurantImage);
            name = itemView.findViewById(R.id.tvRestaurantName);
            category1 = itemView.findViewById(R.id.tvCategory1);
            category2 = itemView.findViewById(R.id.tvCategory2);
            category3 = itemView.findViewById(R.id.tvCategory3);
            cvCategory1 = itemView.findViewById(R.id.cvCategory1);
            cvCategory2 = itemView.findViewById(R.id.cvCategory2);
            cvCategory3 = itemView.findViewById(R.id.cvCategory3);

        }
    }
}
