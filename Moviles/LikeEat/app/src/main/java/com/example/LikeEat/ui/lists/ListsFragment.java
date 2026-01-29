package com.example.LikeEat.ui.lists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.LikeEat.databinding.FragmentListsBinding;


public class ListsFragment extends Fragment {

    private FragmentListsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}