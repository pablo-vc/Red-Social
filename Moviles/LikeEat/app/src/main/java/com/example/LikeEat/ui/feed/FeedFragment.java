package com.example.LikeEat.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.LikeEat.Restaurant;
import com.example.LikeEat.adapters.FeedAdapter;
import com.example.LikeEat.databinding.FragmentFeedBinding;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;

public class FeedFragment extends Fragment {

    private FragmentFeedBinding binding;
    private FeedViewModel viewModel;
    private FeedAdapter adapter;
    private CardStackLayoutManager layoutManager;
    OnCardActionListener cardListener;
    CardStackListener cardStackListener;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        binding = FragmentFeedBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(FeedViewModel.class);

        viewModel.cargarMockRestaurants();
        viewModel.getRestaurants().observe(getViewLifecycleOwner(), lista -> {
            adapter.setRestaurantes(lista);
        });
        setUpListeners();
        setupCardStack();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setUpListeners() {
        cardListener = new OnCardActionListener() {
            @Override
            public void onLike() {
                swipeRight();
            }

            @Override
            public void onDislike() {
                swipeLeft();
            }

            @Override
            public void onRefresh() {
                binding.cardStackView.rewind();
            }
        };
        cardStackListener = new CardStackListener() {

            @Override
            public void onCardDragging(Direction direction, float ratio) {
            }

            @Override
            public void onCardSwiped(Direction direction) {
                int position = layoutManager.getTopPosition() - 1;
                Restaurant r = adapter.getItem(position);
                if (direction == Direction.Right) {
                    // LIKE
                    Toast.makeText(getContext(), "Like", Toast.LENGTH_SHORT).show();
                    viewModel.addLiked(r);
                } else if (direction == Direction.Left) {
                    // DISLIKE
                    Toast.makeText(getContext(), "Dislike", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCardRewound() {
            }

            @Override
            public void onCardCanceled() {
            }

            @Override
            public void onCardAppeared(View view, int position) {
            }

            @Override
            public void onCardDisappeared(View view, int position) {
            }
        };
    }



    private void setupCardStack() {

        layoutManager = new CardStackLayoutManager(requireContext(), cardStackListener);

        layoutManager.setStackFrom(StackFrom.Top);
        layoutManager.setVisibleCount(3);
        layoutManager.setTranslationInterval(8f);
        layoutManager.setScaleInterval(0.95f);
        layoutManager.setSwipeThreshold(0.3f);
        layoutManager.setMaxDegree(15f);
        layoutManager.setDirections(Direction.HORIZONTAL);
        layoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);

        binding.cardStackView.setLayoutManager(layoutManager);

        adapter = new FeedAdapter(new ArrayList<>(), cardListener);

        binding.cardStackView.setAdapter(adapter);
    }

    private void swipeRight() {
        SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();

        layoutManager.setSwipeAnimationSetting(setting);
        binding.cardStackView.swipe();
    }

    private void swipeLeft() {
        SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(new AccelerateInterpolator())
                .build();

        layoutManager.setSwipeAnimationSetting(setting);
        binding.cardStackView.swipe();
    }


}
