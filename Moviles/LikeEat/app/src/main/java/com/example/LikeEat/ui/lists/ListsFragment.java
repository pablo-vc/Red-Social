
package com.example.LikeEat.ui.lists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.LikeEat.databinding.FragmentListsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListsFragment extends Fragment {

    private FragmentListsBinding binding;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private FloatingActionButton btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListsBinding.inflate(inflater, container, false);
        initUI();
        setUpListeners();
        return binding.getRoot();
    }

    private void initUI() {
        rv1 = binding.rvLists;
        rv2 = binding.rvListElements;
        btnAdd = binding.btnAdd;
    }

    private void setUpListeners() {
        btnAdd.setOnClickListener(v -> {
            addList();
        });
    }

    private void addList() {
    }


}