package com.example.android1l6.ui.fragments.third;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1l6.R;
import com.example.android1l6.databinding.FragmentThirdBinding;
import com.example.android1l6.ui.fragments.second.SecondFragment;


public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvStart.setText("Нажми кнопку))");
        setupListener();
    }

    private void setupListener() {
        binding.btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                getParentFragmentManager().beginTransaction().replace(R.id.container_fragment, secondFragment).commit();

            }
        });
    }

}