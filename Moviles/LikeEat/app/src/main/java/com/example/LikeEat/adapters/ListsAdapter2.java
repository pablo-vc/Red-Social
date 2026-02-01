package com.example.LikeEat.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LikeEat.R;
import com.example.LikeEat.Restaurant;
import com.example.LikeEat.ui.feed.OnCardActionListener;

import java.util.List;

public class ListsAdapter2 extends RecyclerView.Adapter<ListsAdapter2.ListsViewHolder> {
    private List<Restaurant> likedRestaurants;
    private OnCardActionListener Cardlistener;


    public ListsAdapter2(List<Restaurant> likedRestaurants, OnCardActionListener CardListener) {
        this.likedRestaurants = likedRestaurants;
        this.Cardlistener = CardListener;
    }
    public void setLikedRestaurants(List<Restaurant> likedRestaurants) {
        this.likedRestaurants = likedRestaurants;
        notifyDataSetChanged();
    }
    public Restaurant getItem(int position) {
        return likedRestaurants.get(position);
    }

    @NonNull
    @Override
    public ListsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lists2, parent, false);

        return new ListsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ListsViewHolder extends RecyclerView.ViewHolder {
        public ListsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
