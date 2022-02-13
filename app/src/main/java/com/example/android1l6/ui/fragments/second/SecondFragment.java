package com.example.android1l6.ui.fragments.second;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android1l6.R;
import com.example.android1l6.databinding.SecondFragmentBinding;
import com.example.android1l6.model.ModelData;
import com.example.android1l6.ui.fragments.first.FirstFragment;

import java.util.Timer;

public class SecondFragment extends Fragment {
    ModelData modelData;
    private SecondFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = SecondFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
        getData();
    }



    private void listeners() {
        binding.btnToSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment firstFragment = new FirstFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment1, firstFragment).commit();
                save();

            }
        });
    }

    private void save() {
        String data = binding.etData.getText().toString();
        if (data.isEmpty()) {
            binding.etData.setError("Input text");
        } else {
            modelData = new ModelData(data);
            Bundle bundle = new Bundle();
            bundle.putSerializable("key", modelData);
            FirstFragment firstFragment = new FirstFragment();
            firstFragment.setArguments(bundle);
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container_fragment, firstFragment).commit();
        }
    }

    private void getData() {
        if (getArguments() != null) {
            modelData = (ModelData) getArguments().getSerializable("key1");
            binding.etData.setText(modelData.getData());
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }


}